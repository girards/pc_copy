package com.petitchef.petitchef.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.petitchef.petitchef.R;
import com.petitchef.petitchef.objects.Step;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by nicolasgirardot on 4/26/17.
 */

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {

    private ArrayList<Step> mSteps;
    private Context mContext;

    public StepsAdapter(ArrayList<Step> mSteps, Context mContext) {
        this.mSteps = mSteps;
        this.mContext = mContext;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View stepView = inflater.inflate(R.layout.step_element_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(stepView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Step step = mSteps.get(position);

        TextView description = holder.stepTextView;
        ImageView imageView = holder.stepImageView;

        Picasso.with(getContext()).load(step.getStepPictureUrl()).into(imageView);
        description.setText(step.getStepDescription());
    }

    @Override
    public int getItemCount() {
        return mSteps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView stepImageView;
        TextView stepTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            stepImageView = (ImageView) itemView.findViewById(R.id.step_imageview);
            stepTextView = (TextView) itemView.findViewById(R.id.step_textview);
        }
    }
}
