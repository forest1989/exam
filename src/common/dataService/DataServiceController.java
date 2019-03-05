package common.dataService;

import org.springframework.web.bind.annotation.RequestMapping;
import com.sgcc.uap.mdd.runtime.data.AbstractDataServiceController;
import org.osgi.framework.Bundle;
import org.springframework.stereotype.Controller;
import org.osgi.framework.FrameworkUtil;

@Controller
@RequestMapping("/data")
public class DataServiceController extends AbstractDataServiceController {
	
	public Bundle getBundle() {
		Bundle bundle = FrameworkUtil.getBundle(DataServiceController.class);
		return bundle;
	}
}
