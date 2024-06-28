package com.example.movieapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.LoadState;
import androidx.paging.LoadStateAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.databinding.LoadStateItemBinding;
import com.example.movieapp.model.Movie;

public class MoviesLoadStateApter extends LoadStateAdapter<MoviesLoadStateApter.LoadStateViewHolder>{

    private View.OnClickListener mRetryCallback;



    public MoviesLoadStateApter( View.OnClickListener retryCallback) {
        this.mRetryCallback = retryCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull LoadStateViewHolder loadStateViewHolder, @NonNull LoadState loadState) {


        loadStateViewHolder.bind(loadState);
    }

    @NonNull
    @Override
    public LoadStateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, @NonNull LoadState loadState) {

        return new LoadStateViewHolder(parent,mRetryCallback);
    }

    public static class LoadStateViewHolder extends  RecyclerView.ViewHolder{

        private ProgressBar mProgressBar;
        private TextView mErrorMsg;
        private  Button mRetry;
        public LoadStateViewHolder(@NonNull ViewGroup parent, @NonNull View.OnClickListener retryCallback) {

            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.load_state_item, parent, false));


            LoadStateItemBinding binding = LoadStateItemBinding.bind(itemView);

            mProgressBar = binding.progressBar;
            mErrorMsg = binding.errorMsg;
            mRetry = binding.retryBtn;

            mRetry.setOnClickListener(retryCallback);


        }

        public  void bind(LoadState loadState){

         if(loadState instanceof LoadState.Error){

            LoadState.Error loadtStateError = (LoadState.Error) loadState;

            mErrorMsg.setText(loadtStateError.getError().getLocalizedMessage());

         }

         mProgressBar.setVisibility( loadState instanceof  LoadState.Loading ? View.VISIBLE : View.GONE);
         mRetry.setVisibility( loadState instanceof  LoadState.Loading ? View.VISIBLE : View.GONE);
         mErrorMsg.setVisibility( loadState instanceof  LoadState.Loading ? View.VISIBLE : View.GONE);

        }
    }


}
