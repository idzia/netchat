package com.codecool;

import com.codecool.controlleres.ThreadHandler;

public class NetChat {

    public static void main(String[] args) {
        if (args.length<1) return;

        ThreadHandler netChat = new ThreadHandler(args);
    }
}
