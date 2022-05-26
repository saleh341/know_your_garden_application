package com.example.knowyourgarden;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import de.hdodenhof.circleimageview.CircleImageView;


public class disease  extends ListFragment implements AdapterView.OnItemClickListener {

    ListView list;

    String[] maintitle ={
            "Bacterial","Fungal",
            "Anthracnose","Fungal Blight",
            "Curly Top","Mosaic" ,"Psorosis","Snow Mold","Sooty Mold","Smut","Downy Mildew"
    };

    String[] subtitle ={
            "By Robert","By Jennifer",
            "By John","By Daniel",
            "By Anthony","By Mark","By Donald","By Steven","By Paul","By Andrew","By Timothy",
    };



    Integer[] imgid={
            R.drawable.u1,R.drawable.u2,
            R.drawable.u3,R.drawable.u4,
            R.drawable.u5,
            R.drawable.u1,R.drawable.u2,
            R.drawable.u3,R.drawable.u4,
            R.drawable.u5,
            R.drawable.u1,R.drawable.u2,
            R.drawable.u3,R.drawable.u4,
            R.drawable.u5,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disease, container, false);
//        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_disease, null);

        list=(ListView) view.findViewById(android.R.id.list);
        MyListView adapter=new MyListView(getActivity(), maintitle, subtitle,imgid);
        list.setAdapter(adapter);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter
//                .createFromResource(getActivity(), R.array.Planets, R.layout.mylist);
//        setListAdapter(adapter);
//        getListView().setOnItemClickListener(this);


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        String[] mess = getResources().getStringArray(R.array.Planets);

        // This method will be executed once the timer is over
        Intent i = new Intent(getContext(), postdetail.class);
        startActivity(i);

        Toast.makeText(getActivity(), "Item: " + mess[position], Toast.LENGTH_SHORT).show();
    }
}