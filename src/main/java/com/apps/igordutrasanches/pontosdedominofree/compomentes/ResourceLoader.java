package apps.igordutrasanches.pontosdedominofree.compomentes;

import android.content.Context;

/**
 * Created by igord on 01/05/2019.
 */

public class ResourceLoader {
    public String get(Context context, int res){
        return context.getString(res);
    }
}
