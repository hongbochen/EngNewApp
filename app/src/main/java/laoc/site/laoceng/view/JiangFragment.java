package laoc.site.laoceng.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import laoc.site.laoceng.R;
import laoc.site.laoceng.adapter.ListArtAdapter;
import laoc.site.laoceng.entity.Article;

public class JiangFragment extends Fragment {

    private ListView lv_list;
    private ListArtAdapter artAdapter;
    private Context context;
    private ArrayList<Article> artList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_con,null);

        context = this.getActivity();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        lv_list = (ListView)view.findViewById(R.id.lv_list);


        artAdapter = new ListArtAdapter(context,artList);

        lv_list.setAdapter(artAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    private void initData(){
        String str = context.getResources().getString(R.string.test_brief);

        for(int i = 0;i < 5;i++){
            artList.add(new Article(i,"测试"+1,str,""));
        }
    }
}
