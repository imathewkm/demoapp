package com.mathew.demoapp.adapter;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.bumptech.glide.Glide;
        import com.mathew.demoapp.R;
        import com.mathew.demoapp.response.Doc;

        import java.util.ArrayList;

public class  SearchAdapter extends RecyclerView.Adapter< SearchAdapter.ViewHolder> {

    private Context context;

    ArrayList<Doc> filteredArrayList = new ArrayList<Doc>();


    public  SearchAdapter(Context context, ArrayList<Doc> articleArrayList) {
        this.context = context;

        this.filteredArrayList  = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        try {
            final Doc article = filteredArrayList.get(i);
             viewHolder.tvTitle.setText(article.getAbstract());
            // viewHolder.tvAuthorAndPublishedAt.setText( article.getLeadParagraph());
           viewHolder.tvDescription.setText( article.getLeadParagraph());
            Glide.with(context)
                    .load("https://static01.nyt.com/" + article.getMultimedia().get(0).getUrl())
                    .into(viewHolder.imgViewCover);
        }
        catch (Exception e)
        {

        }
    }

    @Override
    public int getItemCount () {
        return filteredArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;
        private final TextView tvAuthorAndPublishedAt;
        private final TextView tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover=(ImageView) itemView.findViewById(R.id.imgViewCover);
            tvTitle=(TextView) itemView.findViewById(R.id.tvTitle);
            tvAuthorAndPublishedAt=(TextView) itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            tvDescription=(TextView) itemView.findViewById(R.id.tvDescription);
        }
    }

}
