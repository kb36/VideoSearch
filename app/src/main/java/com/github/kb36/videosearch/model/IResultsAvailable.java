package com.github.kb36.videosearch.model;

/**
 * Interface for listening to the results
 * Created by nagarjuna.t1 on 10/23/2015.
 */
public interface IResultsAvailable {
    public static final int SUCCESS = 0;
    public static final int EXCEPTION = 1;
    public void onResultsAvailable(QueryResult results, int error);
}