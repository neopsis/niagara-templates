package ${pkg} ;

import com.neopsis.envas.BNvApplication;
import com.neopsis.envas.NvUI;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;


@NiagaraType
public class BDemo extends BNvApplication {

    @Override
    public String getApplicationName() {
        return "Envas demo";
    }

    @Override
    public String getApplicationDescription() {
        return "Envas demo application";
    }

    @Override
    public NvUI getDesktopUI() {
        return new Demo();
    }
}
