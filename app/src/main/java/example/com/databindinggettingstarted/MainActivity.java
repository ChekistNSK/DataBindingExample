package example.com.databindinggettingstarted;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

import example.com.databindinggettingstarted.databinding.ActivityMainBinding;
import example.com.databindinggettingstarted.models.Product;
import example.com.databindinggettingstarted.util.Products;

public class MainActivity extends AppCompatActivity implements iMainActivity {

    //data binding
    ActivityMainBinding mBinding;

    //vars
    private Product mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Products products = new Products();
        int lenght = products.PRODUCTS.length - 1;

        Random random = new Random();
        int rand = random.nextInt(lenght);
        mProduct = products.PRODUCTS[rand];

        mBinding.setProduct(mProduct);
        mBinding.setQuantity(1);
        mBinding.setIMainActivity((iMainActivity) this);
    }

    @Override
    public void inflateQuantityDialog() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(), getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        mBinding.setQuantity(quantity);
    }
}
