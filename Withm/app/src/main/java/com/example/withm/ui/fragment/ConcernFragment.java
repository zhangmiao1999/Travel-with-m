package com.example.withm.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.withm.R;
import com.example.withm.ui.xzqfragment.activity.AdventureActivity;
import com.example.withm.ui.xzqfragment.activity.MessageActivity;
import com.example.withm.ui.xzqfragment.activity.PhotoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConcernFragment extends Fragment {


    private Toolbar toolBar;
    private RecyclerView rv;
    private ImageView fish;
    private TextView tv1;
    private TextView textView;
    private ImageView iv1;
    private ImageView emil;

    public ConcernFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_concern, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(final View inflate) {
        toolBar = (Toolbar) inflate.findViewById(R.id.toolBar);
        fish = (ImageView) inflate.findViewById(R.id.fish);
        emil = (ImageView) inflate.findViewById(R.id.emil);
        tv1 = (TextView) inflate.findViewById(R.id.tv1);
        textView = (TextView) inflate.findViewById(R.id.textView);
        iv1 = (ImageView) inflate.findViewById(R.id.iv1);
        toolBar.setTitle("");

        emil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MessageActivity.class));
            }
        });
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AdventureActivity.class));
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PhotoActivity.class));
            }
        });
    }

}
