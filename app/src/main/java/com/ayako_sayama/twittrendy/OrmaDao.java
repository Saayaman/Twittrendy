package com.ayako_sayama.twittrendy;

import android.content.Context;

import com.github.gfx.android.orma.AccessThreadConstraint;

/**
 * Created by ayako_sayama on 2017-03-20.
 */

public class OrmaDao {

    private static OrmaDatabase orma;

    public OrmaDao(Context context) {
        if (orma == null) {
            orma = new OrmaDatabase.Builder(context)
                    .writeOnMainThread(AccessThreadConstraint.NONE)
                    .readOnMainThread(AccessThreadConstraint.NONE)
                    .build();
        }
    }

    public Tab_Selector findAll() {
        return orma.relationOfTab().selector();
    }

    public void insert(Tab tab) {
        orma.relationOfTab().inserter().execute(tab);
    }

    public void delete(Tab tab) {
        orma.relationOfTab().deleter()
                .idEq(tab.id)
                .execute();
    }

    public void update(Tab tab) {
        orma.relationOfTab().updater()
                .idEq(tab.id)
                .tabName(tab.tabName)
                .execute();
    }


}
