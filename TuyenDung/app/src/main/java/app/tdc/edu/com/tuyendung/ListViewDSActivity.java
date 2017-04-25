package app.tdc.edu.com.tuyendung;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import app.tdc.edu.com.tuyendung.Adapter.MyAdapter;
import app.tdc.edu.com.tuyendung.Object.Link;
import app.tdc.edu.com.tuyendung.Object.ThuocTinh;

public class ListViewDSActivity extends Activity {
    // URL Address
    String url = "";
    static ArrayList<ThuocTinh> questions = new ArrayList<ThuocTinh>();
    ListView lvDanhSach;
    MyAdapter adapter;
    static ArrayList<Link> arrlink = new ArrayList<Link>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgBack = (ImageView) findViewById(R.id.btnBack);
        lvDanhSach = (ListView) findViewById(R.id.lvdanhsach);
        getAndUpdateLink();
        new _JSOUP().execute();

        imgBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { // TODO Auto-generated method stub
                Intent intent = new Intent(ListViewDSActivity.this,SearchActiviry.class);
                startActivity(intent);
                finish();
            }
        });

    }
    //lay duong dan
    void getAndUpdateLink() {
        Intent intent = getIntent();
        // Log.d("intent", "intent " + intent);
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra("data");
            Log.d("aaa", bundle + "");
            if (bundle != null) {
                Link link = new Link(bundle.getString("link"));
                Log.d("du lieu da lay", link + "");
                url = link + "";
            } else {
                arrlink.clear();
            }
        }
    }
    //loadding
    private class _JSOUP extends AsyncTask<Void, Integer, ArrayList<ThuocTinh>> {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            dialog = new ProgressDialog(ListViewDSActivity.this);
            dialog.setMessage("loading...");
            Log.d("aaa", dialog + "");
            dialog.show();

        }
        //khai bao duong dan html
        @Override
        protected ArrayList<ThuocTinh> doInBackground(Void... arg0) {
            questions = new ArrayList<ThuocTinh>();

            // TODO Auto-generated method stub
            try {
                // Log.d("da vao", "da vao toi day");
                Document doccument = Jsoup.connect(url).get();
                Elements tieude = doccument.select("h3.job");
//                Log.d("aaa", tieude + "");
                Elements tencty = doccument.select("p.namecom");
                Elements diadiem = doccument.select("p.location");
                Elements luong = doccument.select("p.salary");
                Elements ngaydang = doccument.select("div.dateposted");

                Elements url2 = doccument.select("h3.job");

                for (int i = 0; i < url2.size() && i < tieude.size()
                        && i < tencty.size() && i < diadiem.size()
                        && i < luong.size() && i < ngaydang.size(); i++) {

                    ThuocTinh question = new ThuocTinh("\n" + tieude.get(i).text(),
                            "\n" + tencty.get(i).text(), "\n"
                            + diadiem.get(i).text(), "\n"
                            + luong.get(i).text(), "\n"
                            + ngaydang.get(i).text(), "\n"
                            + url2.get(i).select("a").attr("href"));
                    questions.add(question);
                }
            } catch (Exception e) {
                // TODO: handle exception
                // Log.d("da vao toi day 1", "da vao toi day 1");
            }
            return questions;
            // TODO Auto-generated method stub
        }


        @Override
        protected void onPostExecute(ArrayList<ThuocTinh> result) {

            super.onPostExecute(result);
            Log.d("Hai", result.size()+"");

            lvDanhSach = (ListView) findViewById(R.id.lvdanhsach);
            adapter = new MyAdapter(ListViewDSActivity.this,
                    R.layout.item_main, result);
            lvDanhSach.setAdapter(adapter);
            lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    Intent intent = new Intent(ListViewDSActivity.this,
                            WebviewActivity.class);
                    String link = questions.get(position).getLink();
                    Bundle bundle = new Bundle();
                    bundle.putString("link", link);
                    intent.putExtra("dataLink", bundle);
                    startActivity(intent);
                }
            });
            dialog.dismiss();

        }
    }
}

