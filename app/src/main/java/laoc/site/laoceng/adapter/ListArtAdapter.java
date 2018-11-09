package laoc.site.laoceng.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import laoc.site.laoceng.R;
import laoc.site.laoceng.entity.Article;

public class ListArtAdapter extends BaseAdapter {
    private Context context;

    private LayoutInflater inflater;
    private List<Article> artList;

    public ListArtAdapter(Context context,List<Article> artList){
        this.context = context;
        this.artList = artList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return artList == null ? 0 : artList.size();
    }

    @Override
    public Object getItem(int position) {
        return artList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Holder holder = null;

        if(view == null){
            holder = new Holder();

            view = inflater.inflate(R.layout.art_item, null);

            holder.iv_item_img = (ImageView)view.findViewById(R.id.iv_item_img);
            holder.tv_art_name = (TextView) view.findViewById(R.id.tv_art_name);
            holder.tv_art_brief = (TextView)view.findViewById(R.id.tv_art_brief);

            view.setTag(holder);
        }else{
            holder = (Holder)view.getTag();
        }

        holder.tv_art_name.setText(artList.get(position).getArtName());
        holder.tv_art_brief.setText(artList.get(position).getArtBrief());

        return view;
    }

    class Holder{
        ImageView iv_item_img;
        TextView tv_art_name;
        TextView tv_art_brief;
    }
}
