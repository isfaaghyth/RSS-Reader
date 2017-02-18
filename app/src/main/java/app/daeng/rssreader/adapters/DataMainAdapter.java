package app.daeng.rssreader.adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.daeng.rssreader.R;
import app.daeng.rssreader.models.ItemMainObject;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 18/2/17.
 */

public class DataMainAdapter extends RecyclerView.Adapter<DataMainAdapter.DataMainHolder> {

    private List<ItemMainObject.Channel.Item> itemObjects;

    public DataMainAdapter(List<ItemMainObject.Channel.Item> itemObjects) {
        this.itemObjects = itemObjects;
    }

    @Override
    public DataMainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DataMainHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(DataMainHolder holder, final int position) {
        holder.txtJudul.setText(itemObjects.get(position).getTitle());
        holder.txtDeskripsi.setText(itemObjects.get(position).getDescription());
        holder.cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemObjects.get(position).getLink()));
                view.getContext().startActivity(browserIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemObjects.size();
    }

    class DataMainHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_item)
        CardView cardItem;

        @BindView(R.id.txt_judul)
        TextView txtJudul;

        @BindView(R.id.txt_deskripsi)
        TextView txtDeskripsi;

        DataMainHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
