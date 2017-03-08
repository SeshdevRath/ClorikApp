package com.example.user.clorikapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 25-11-2016.
 */
public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    int[] images;
    String[] names;

    private ArrayList<DataModel> dataModels;

    public static final int ITEM_TYPE_USER = 0;
    public static final int ITEM_TYPE_CONTENT = 1;
    public static final int ITEM_TYPE_CHOICE = 2;

    MyAdapter(Context context, ArrayList<DataModel> dataModels)
    {
        this.context = context;
        this.dataModels = dataModels;
    }

    @Override
    public int getItemViewType(int position) {
        if (dataModels != null) {
            DataModel object = dataModels.get(position);
            if (object != null) {
                return object.getType();
            }
        }
        return 0;
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;

        if (viewType == ITEM_TYPE_USER){
            view = inflater.inflate(R.layout.user_row, parent, false);
            return new ViewHolderUser(view);
        } else if (viewType == ITEM_TYPE_CONTENT){
            view = inflater.inflate(R.layout.content_row, parent, false);
            return new ViewHolderContent(view);
        } else if (viewType == ITEM_TYPE_CHOICE){
            view = inflater.inflate(R.layout.choice_row, parent, false);
            return new ViewHolderChoice(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        DataModel object = dataModels.get(position);

        if (object != null){

            if (object.getType() == ITEM_TYPE_USER){
                ViewHolderUser viewHolderUser = (ViewHolderUser) holder;
                viewHolderUser.imageView_user_1.setImageResource(object.getImages1());
                viewHolderUser.imageView_user_2.setImageResource(object.getImages2());
                viewHolderUser.textView_user.setText(object.getTitles1());
            } else if (object.getType() == ITEM_TYPE_CONTENT){
                ViewHolderContent viewHolderContent = (ViewHolderContent) holder;
                viewHolderContent.imageView_content.setImageResource(object.getImages2());
                viewHolderContent.textView_content.setText(object.getTitles1());
            } else if (object.getType() == ITEM_TYPE_CHOICE){
                ViewHolderChoice viewHolderChoice = (ViewHolderChoice) holder;
                viewHolderChoice.imageView_choice.setImageResource(object.getImages2());
                viewHolderChoice.textView_choice_1.setText(object.getTitles1());
                viewHolderChoice.textView_choice_2.setText(object.getTitles2());
            }
        }
    }

    @Override
    public int getItemCount() {

        if (dataModels == null)
            return 0;
        return dataModels.size();
    }

    public class ViewHolderUser extends RecyclerView.ViewHolder {

        private CircleImageView imageView_user_1;
        ImageView imageView_user_2;
        private TextView textView_user;
        public ViewHolderUser(View itemView) {
            super(itemView);
            imageView_user_1 = (CircleImageView) itemView.findViewById(R.id.user_imageView1);
            imageView_user_2 = (ImageView) itemView.findViewById(R.id.user_imageView2);
            textView_user = (TextView) itemView.findViewById(R.id.user_textview);
        }
    }

    public class ViewHolderContent extends RecyclerView.ViewHolder {

        private TextView textView_content;
        private ImageView imageView_content;
        public ViewHolderContent(View itemView) {
            super(itemView);
            textView_content = (TextView) itemView.findViewById(R.id.content_textview);
            imageView_content = (ImageView) itemView.findViewById(R.id.content_imageview);
        }
    }

    public class ViewHolderChoice extends RecyclerView.ViewHolder {

        private TextView textView_choice_1, textView_choice_2;
        private ImageView imageView_choice;
        public ViewHolderChoice(View itemView) {
            super(itemView);
            textView_choice_1 = (TextView) itemView.findViewById(R.id.choice_textview);
            textView_choice_2 = (TextView) itemView.findViewById(R.id.choice_textView2);
            imageView_choice = (ImageView) itemView.findViewById(R.id.choice_imageview);
        }
    }
}
