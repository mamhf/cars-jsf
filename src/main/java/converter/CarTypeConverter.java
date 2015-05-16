package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import services.interfaces.RentalServicesLocal;
import beans.CarTypeBean;
import domain.CarType;

@FacesConverter("cartypeconverter")
public class CarTypeConverter implements Converter {
	@EJB
	private RentalServicesLocal rentalServicesLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null) {
			return null;
		}
		CarTypeBean carTypeBean = context.getApplication()
				.evaluateExpressionGet(context, "#{carTypeBean}",
						CarTypeBean.class);
		CarType carType = carTypeBean.getCartypeByName(value);

		return carType;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String string = null;
		if (value instanceof CarType) {
			string = ((CarType) value).getName();
		}
		return string;
	}

}
