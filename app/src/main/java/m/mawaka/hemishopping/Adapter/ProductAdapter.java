package m.mawaka.hemishopping.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import m.mawaka.hemishopping.Model.Product;
import m.mawaka.hemishopping.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    ArrayList<Product> productArrayList;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.product_layoutn,viewGroup,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.txtname.setText(productArrayList.get(position).getName());
        holder.price.setText(productArrayList.get(position).getPrice());

        Picasso.get()
                .load(productArrayList.get(position).getLink())
                .into(holder.imageViewtop);



    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewtop;
        TextView txtname,price;

//        String price,description,specification,size,quantity,link,left_image,back_image,front_image;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewtop = itemView.findViewById(R.id.image_product);
            txtname= itemView.findViewById(R.id.productName);
            price= itemView.findViewById(R.id.price);
        }
    }
}
