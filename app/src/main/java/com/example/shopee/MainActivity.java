package com.example.shopee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private Timer timer;

    private ArrayList<Integer> listPhoto;
    private ArrayList<FlashSale> lisFlashSales;
    private ArrayList<Product> listProducts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getListPhoto();
        autoSlide();
        initFlashSale();
        initProduct();

    }
    private void initProduct() {
        RecyclerView rcv_flashsale = findViewById(R.id.rcv_product);
        rcv_flashsale.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rcv_flashsale.setLayoutManager(grid);

        listProducts =  new ArrayList<>();

        listProducts.add(new Product("Dây cáp VENTION kết nối âm thanh chuyển đổi cổng HDMI sang VGA HD 1080P", "https://cf.shopee.vn/file/e0c23982f8e6ca68625ff1ae7f039fab_tn", "132000","80000"));
        listProducts.add(new Product("Màn Hình Samsung LF24T350FHEXXV 24 FHD IPS 75Hz 5ms AMD Freesync Viền Mỏng 3 Cạnh Chân-V", "https://salt.tikicdn.com/cache/w64/ts/product/58/03/a1/54172996216b0eea1fc9eefc55e9c4a0.jp","3190000","3339000"));
        listProducts.add(new Product("CHÂN VÁY KAKI DÀI XOÈ TRƠN TRẮNG ĐEN BE - CHÂN VÁY", "https://cf.shopee.vn/file/53e96d0e50db545246b42670ada39c12_tn","70000","59000"));
        listProducts.add(new Product("Màn Hình Siêu Mỏng Asus VZ249HE 23.8 Full HD (1920x1080) IPS Bảo Vệ Mắt","https://cf.shopee.vn/file/4ec15382fe0c968bfcb7d44b93df6123&quot", "3999000","3333000"));
        listProducts.add(new Product("Combo Bánh pía kim sa Tân Huê Viên 10 bánh 10 vị khác nhau","https://cf.shopee.vn/file/1489bd525a6ca748c3544ba00209aca5", "90000", "71000"));
        listProducts.add(new Product("COMBO GHẾ CHƠI GAME + BÀN GỖ","https://cf.shopee.vn/file/97aa7fd30ed55fed6ace9c6b5dceb093", "2198000", "599000"));
        ProductAdapter flashSaleAdapter = new ProductAdapter(listProducts, this, R.layout.item_product);
        rcv_flashsale.setAdapter(flashSaleAdapter);

    }

    private void initFlashSale() {
        RecyclerView rcv_flashsale = findViewById(R.id.rcv_flashsale);
        rcv_flashsale.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false);
        rcv_flashsale.setLayoutManager(grid);

        lisFlashSales =  new ArrayList<>();

        lisFlashSales.add(new FlashSale(R.drawable.flashsale1,40000,2));
        lisFlashSales.add(new FlashSale(R.drawable.flashsale2,40000,2));
        lisFlashSales.add(new FlashSale(R.drawable.flashsale75,40000,2));
        lisFlashSales.add(new FlashSale(R.drawable.flashsale179,40000,2));
        lisFlashSales.add(new FlashSale(R.drawable.flashsale252,40000,2));
        lisFlashSales.add(new FlashSale(R.drawable.flashsale455,40000,2));
        FlashSaleAdapter flashSaleAdapter = new FlashSaleAdapter(lisFlashSales, this, R.layout.item_flashsale);
        rcv_flashsale.setAdapter(flashSaleAdapter);

    }

    private void autoSlide() {
        if (listPhoto == null || listPhoto.isEmpty() || viewPager == null){
            return;
        }
        if (timer == null){
            timer =new Timer();

        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalImg = listPhoto.size() - 1;
                        if ((currentItem < totalImg)){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },400,3000);
    }

    private void getListPhoto() {
        listPhoto = new ArrayList<>();
        viewPager = findViewById(R.id.viewpager);
        circleIndicator = findViewById(R.id.circle_indicator);

        listPhoto.add(R.drawable.banner1);
        listPhoto.add(R.drawable.banner2);
        listPhoto.add(R.drawable.banner3);
        listPhoto.add(R.drawable.banner4);
        listPhoto.add(R.drawable.banner5);
        listPhoto.add(R.drawable.banner6);
        listPhoto.add(R.drawable.banner7);
        listPhoto.add(R.drawable.banner8);

        BannerAdapter bannerAdapter = new BannerAdapter(this,listPhoto);
        viewPager.setAdapter(bannerAdapter);

        circleIndicator.setViewPager(viewPager);
        bannerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

    }
}