package com.example.atmajayarental;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.atmajayarental.api.ApiClient;
import com.example.atmajayarental.api.ApiInterface;
import com.example.atmajayarental.databinding.ActivityCustomerLaporanBinding;
import com.example.atmajayarental.models.TransaksiJoinCustomer;
import com.example.atmajayarental.response.TransaksiJoinCustomerResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerLaporanActivity extends AppCompatActivity {


    private static final String[] BULAN_LIST = new String[]{"Januari", "Februari", "Maret", "April", "Mei",
            "Juni", "Juli", "Agustus", "September", "Oktober","November","Desember"};
    private static final String[] TAHUN_LIST = new String[]{"2022", "2023", "2024"};

    private ActivityCustomerLaporanBinding binding;
    private ApiInterface apiService;
    private AutoCompleteTextView edBulan, edTahun;
    private String bulan;
    private String tahun;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        //bottomNavigation.setSelectedItemId(R.id.person);
        binding = ActivityCustomerLaporanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = ApiClient.getClient().create(ApiInterface.class);
        edBulan = findViewById(R.id.ed_bulan);
        edTahun = findViewById(R.id.ed_tahun);
        ArrayAdapter<String> adapterBulan = new ArrayAdapter<>(this, R.layout.item_list, BULAN_LIST);
        edBulan.setAdapter(adapterBulan);
        ArrayAdapter<String> adapterTahun = new ArrayAdapter<>(this, R.layout.item_list, TAHUN_LIST);
        edTahun.setAdapter(adapterTahun);

        binding.btnCetak.setOnClickListener(V -> {
//            try {
            laporanCustomer(bulan, tahun);
//                System.out.println("halo");
//            } catch (FileNotFoundException | DocumentException e) {
//                e.printStackTrace();
//            }
        });
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.person:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        return true;

//                    case R.id.about:
//                        startActivity(new Intent(getApplicationContext(),About.class));
//                        overridePendingTransition(0,0);
//                        return true;

                }
                return true;
            }
        });

    }

    private void laporanCustomer(String bulan,String tahun) {
        int numberMonth=0;
        String chooseMonth = String.valueOf(edBulan.getText());
        int chooseYear = Integer.parseInt(String.valueOf(edTahun.getText()));
        switch (chooseMonth) {
            case "Januari":
                numberMonth = 1;
                break;
            case "Februari":
                numberMonth = 2;
                break;
            case "Maret":
                numberMonth = 3;
                break;
            case "April":
                numberMonth = 4;
                break;
            case "Mei":
                numberMonth = 5;
                break;
            case "Juni":
                numberMonth = 6;
                break;
            case "Juli":
                numberMonth = 7;
                break;
            case "Agustus":
                numberMonth = 8;
                break;
            case "September":
                numberMonth = 9;
                break;
            case "Oktober":
                numberMonth = 10;
                break;
            case "November":
                numberMonth = 11;
                break;
            case "Desember":
                numberMonth = 12;
                break;
        }
        Call<TransaksiJoinCustomerResponse> call = apiService.laporanCustomer(numberMonth,chooseYear);

        call.enqueue(new Callback<TransaksiJoinCustomerResponse>() {
            @Override
            public void onResponse(Call<TransaksiJoinCustomerResponse> call,
                                   Response<TransaksiJoinCustomerResponse> response) {
                if (response.isSuccessful()) {
//                    adapter.setMahasiswaList(response.body().getMahasiswaList());
//                    adapter.getFilter().filter(svMahasiswa.getQuery());
                    try {
                        cetakPdf(response.body().getTransaksiJoinCustomerList());
                    } catch(FileNotFoundException | DocumentException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        JSONObject jObjError = new
                                JSONObject(response.errorBody().string());
                        Toast.makeText(CustomerLaporanActivity.this,
                                jObjError.toString(),
                                Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(CustomerLaporanActivity.this,
                                e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
//                srMahasiswa.setRefreshing(false);
//                srMahasiswa.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<TransaksiJoinCustomerResponse> call, Throwable t) {
                Toast.makeText(CustomerLaporanActivity.this, "Network error",
                        Toast.LENGTH_SHORT).show();
//                srMahasiswa.setRefreshing(false);
            }
        });



    }

    private void cetakPdf(List<TransaksiJoinCustomer> transaksiJoinCustomerList) throws FileNotFoundException, DocumentException {
/*
* Untuk Android 11 nanti file pdf tidak bisa diakses lewat file
manager HP langsung
* jadi harus konek lewat PC gara gara implementasi Scoped Storage.
*
* Kalau mau biar bisa di android 11 bisa pelajari sendiri tentang
penggunaan MediaStorage
* */
        File folder = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        if (!folder.exists()) {
            folder.mkdir();
        }
        Date currentTime = Calendar.getInstance().getTime();
        String pdfName = currentTime.getTime() + ".pdf";
        File pdfFile = new File(folder.getAbsolutePath(), pdfName);
        OutputStream outputStream = new FileOutputStream(pdfFile);
        com.itextpdf.text.Document document = new
                com.itextpdf.text.Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);
        document.open();
        // bagian header
        Paragraph judul = new Paragraph("Atma Jaya Rental\n\n",
                new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 14,
                        Font.BOLD, BaseColor.BLACK));
        judul.setAlignment(Element.ALIGN_CENTER);
        document.add(judul);

        // Buat tabel
        PdfPTable tables = new PdfPTable(new float[]{16, 8});
        // Settingan ukuran tabel
        tables.getDefaultCell().setFixedHeight(50);
        tables.setTotalWidth(PageSize.A4.getWidth());
        tables.setWidthPercentage(100);
        tables.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        PdfPCell cellSupplier = new PdfPCell();
        cellSupplier.setPaddingLeft(20);
        cellSupplier.setPaddingBottom(10);
        cellSupplier.setBorder(Rectangle.NO_BORDER);
//        Paragraph kepada = new Paragraph(
//                "Kepada Yth: \n" + "Budi Setiawan" + "\n",
//                new com.itextpdf.text.Font(Font.FontFamily.TIMES_ROMAN, 10,
//                        Font.NORMAL, BaseColor.BLACK));
//        cellSupplier.addElement(kepada);
//        tables.addCell(cellSupplier);
//        Paragraph NomorTanggal = new Paragraph(
//                "No : " + "123456789" + "\n\n" +
//                        "Tanggal : " + new SimpleDateFormat("dd/MM/yyyy",
//                        Locale.getDefault()).format(currentTime) + "\n",
//                new
//                        com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
//                        com.itextpdf.text.Font.NORMAL, BaseColor.BLACK));
//        NomorTanggal.setPaddingTop(5);
//        tables.addCell(NomorTanggal);
        document.add(tables);
        com.itextpdf.text.Font f = new
                com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        Paragraph Pembuka = new Paragraph("Bulan "+ edBulan.getText()+" "+edTahun.getText()+"\n\n", f);
        //Pembuka.setIndentationLeft(20);
        Paragraph Pembuka1 = new Paragraph("Laporan 5 Customer dengan Jumlah Transaksi Terbanyak pada Bulan Tertentu \n\n", f);
        Pembuka1.setAlignment(Element.ALIGN_CENTER);
        document.add(Pembuka1);
        document.add(Pembuka);

        PdfPTable tableHeader = new PdfPTable(new float[]{5, 5});

        tableHeader.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        tableHeader.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        tableHeader.getDefaultCell().setFixedHeight(30);
        tableHeader.setTotalWidth(PageSize.A4.getWidth());
        tableHeader.setWidthPercentage(100);
        // Setup Column
        PdfPCell h1 = new PdfPCell(new Phrase("Nama Customer"));
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        h1.setPaddingBottom(5);
        PdfPCell h2 = new PdfPCell(new Phrase("Jumlah Transaksi"));
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        h2.setPaddingBottom(5);
//        PdfPCell h3 = new PdfPCell(new Phrase("Jumlah Peminjaman"));
//        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        h3.setPaddingBottom(5);
//        PdfPCell h4 = new PdfPCell(new Phrase("Pendapatan"));
//        h4.setHorizontalAlignment(Element.ALIGN_CENTER);
//        h4.setPaddingBottom(5);
//        PdfPCell h5 = new PdfPCell(new Phrase("Gaji"));
//        h5.setHorizontalAlignment(Element.ALIGN_CENTER);
//        h5.setPaddingBottom(5);
        tableHeader.addCell(h1);
        tableHeader.addCell(h2);
//        tableHeader.addCell(h3);
//        tableHeader.addCell(h4);
//        tableHeader.addCell(h5);
        // Beri warna untuk kolumn
        for (PdfPCell cells : tableHeader.getRow(0).getCells()) {
            cells.setBackgroundColor(BaseColor.PINK);
        }
        document.add(tableHeader);
        PdfPTable tableData = new PdfPTable(new float[]{5, 5});

        tableData.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        tableData.getDefaultCell().setFixedHeight(30);
        tableData.setTotalWidth(PageSize.A4.getWidth());
        tableData.setWidthPercentage(100);
        tableData.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        // masukan data pegawai jadi baris
        for (TransaksiJoinCustomer t : transaksiJoinCustomerList) {
            tableData.addCell(t.getNama());
            tableData.addCell(String.valueOf(t.getJumlahTransaksi()));
            //dan lain lain
        }
        document.add(tableData);
        com.itextpdf.text.Font h = new

                com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.TIMES_ROMAN, 10,
                com.itextpdf.text.Font.NORMAL);
        String tglDicetak = currentTime.toLocaleString();
        Paragraph P = new Paragraph("\nDicetak tanggal " + tglDicetak, h);
        P.setAlignment(Element.ALIGN_RIGHT);
        document.add(P);
        document.close();
        previewPdf(pdfFile);
        Toast.makeText(this, "PDF berhasil dibuat", Toast.LENGTH_SHORT).show();
    }

    private void previewPdf(File pdfFile) {
        PackageManager packageManager = getPackageManager();
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        testIntent.setType("application/pdf");
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(testIntent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        if (list.size() > 0) {
            Uri uri;
            uri = FileProvider.getUriForFile(this, getPackageName() +
                            ".provider",
                    pdfFile);
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(uri, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            this.grantUriPermission(getPackageName(), uri,
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION |
                            Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(pdfIntent);
        }
    }
}