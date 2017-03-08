package com.example.user.clorikapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by User on 13-07-2016.
 */
public class FragmentA extends Fragment {

    private RecyclerView recyclerView;

    int[] images={R.drawable.meme10, R.drawable.meme10, R.drawable.meme3, R.drawable.meme4, R.drawable.meme5, R.drawable.meme6, R.drawable.meme10, R.drawable.meme8, R.drawable.meme9, R.drawable.meme10};
    int[] images1={R.drawable.ic_action_add_white, R.drawable.ic_action_add_white, R.drawable.ic_action_content, R.drawable.ic_action_content, R.drawable.ic_action_choice, R.drawable.ic_action_content, R.drawable.ic_action_add_white, R.drawable.ic_action_choice, R.drawable.ic_action_choice, R.drawable.ic_action_add_white};
    String[] titles={"User 1", "User 2","Content 1", "Content 2", "Choice 1", "Content 3", "User 3", "Choice 2", "Choice 3", "User 4"};
    String[] description={"Subtitle", "Subtitle","Subtitle", "Subtitle", "Subtitle", "Subtitle", "Subtitle", "Subtitle", "Subtitle", "Subtitle"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<DataModel> data = new ArrayList<>();
        data.add(new DataModel(images[0], titles[0], description[0], images1[0], DataModel.ITEM_TYPE_USER));
        data.add(new DataModel(images[1], titles[1], description[1], images1[1], DataModel.ITEM_TYPE_USER));
        data.add(new DataModel(images[2], titles[2], description[2], images1[2], DataModel.ITEM_TYPE_CONTENT));
        data.add(new DataModel(images[3], titles[3], description[3], images1[3], DataModel.ITEM_TYPE_CONTENT));
        data.add(new DataModel(images[4], titles[4], description[4], images1[4], DataModel.ITEM_TYPE_CHOICE));
        data.add(new DataModel(images[5], titles[5], description[5], images1[5], DataModel.ITEM_TYPE_CONTENT));
        data.add(new DataModel(images[6], titles[6], description[6], images1[6], DataModel.ITEM_TYPE_USER));
        data.add(new DataModel(images[7], titles[7], description[7], images1[7], DataModel.ITEM_TYPE_CHOICE));
        data.add(new DataModel(images[8], titles[8], description[8], images1[8], DataModel.ITEM_TYPE_CHOICE));
        data.add(new DataModel(images[9], titles[9], description[9], images1[9], DataModel.ITEM_TYPE_USER));

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerView);
        MyAdapter adapter = new MyAdapter(getActivity().getApplicationContext(), data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
    }
}
