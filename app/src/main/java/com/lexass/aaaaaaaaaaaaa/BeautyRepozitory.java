package com.lexass.aaaaaaaaaaaaa;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class BeautyRepozitory  {

    private BeautyDAO mBeautyDao;
    private LiveData<List<Beauty>> mAllBeautis ;

    public BeautyRepozitory (Application application){
        BeautyDatabase db = BeautyDatabase.getDatabase(application);
        mBeautyDao = db.beautyDAO();
        mAllBeautis = mBeautyDao.getAllBeautisLive();
    }

    public void insert(Beauty beauty){
        new InsertBeautisAsyncTask(mBeautyDao).execute(beauty);
    }

    public void update(Beauty beauty){
        new UpdateBeautisAsyncTask(mBeautyDao).execute(beauty);
    }

    public void delete(Beauty beauty){
        new DeleteBeautisAsyncTask(mBeautyDao).execute(beauty);
    }

    public LiveData<List<Beauty>> getAllBeautis(){
        return mAllBeautis;
    }

    private static class InsertBeautisAsyncTask extends AsyncTask<Beauty, Void, Void>{
        private BeautyDAO beautyDAO;
        private InsertBeautisAsyncTask(BeautyDAO beautyDAO){
            this.beautyDAO = beautyDAO;
        }

        @Override
        protected Void doInBackground(Beauty... beauties) {
            beautyDAO.AddBeauty(beauties[0]);
            return null;
        }
    }

    private static class UpdateBeautisAsyncTask extends AsyncTask<Beauty, Void, Void>{
        private BeautyDAO beautyDAO;
        private UpdateBeautisAsyncTask(BeautyDAO beautyDAO){
            this.beautyDAO = beautyDAO;
        }

        @Override
        protected Void doInBackground(Beauty... beauties) {
            beautyDAO.UpdateBeauty(beauties[0]);
            return null;
        }
    }

    private static class DeleteBeautisAsyncTask extends AsyncTask<Beauty, Void, Void>{
        private BeautyDAO beautyDAO;
        private DeleteBeautisAsyncTask(BeautyDAO beautyDAO){
            this.beautyDAO = beautyDAO;
        }

        @Override
        protected Void doInBackground(Beauty... beautis) {
            beautyDAO.DeleteBeauty(beautis[0]);
            return null;
        }
    }
}
