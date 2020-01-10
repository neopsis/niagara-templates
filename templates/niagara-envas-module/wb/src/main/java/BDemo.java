package {{pkg}};

import com.neopsis.envas.BNvApplication;
import com.neopsis.envas.NvUI;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * Envas demo application
 *
 */
@NiagaraType
public class BDemo extends BNvApplication {

    /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
    /*@ ${{pkg}}.BDemo(2979906276)1.0$ @*/
    /* Generated Fri Jan 10 10:52:30 CET 2020 by Slot-o-Matic (c) Tridium, Inc. 2012 */

    ////////////////////////////////////////////////////////////////
    // Type
    ////////////////////////////////////////////////////////////////
    @Override
    public Type getType() {
        return TYPE;
    }

    public static final Type TYPE = Sys.loadType(BDemo.class);

    /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
    @Override
    public String getApplicationName() {
        return "Envas demo";
    }

    @Override
    public String getApplicationDescription() {
        return "{{moduleDescription}}";
    }

    @Override
    public NvUI getDesktopUI() {
        return new Demo();
    }
}

