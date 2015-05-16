package beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import services.interfaces.RentalServicesLocal;
import domain.CarType;

@RequestScoped
@ManagedBean(name = "carTypeBean")
public class CarTypeBean {
	@EJB
	private RentalServicesLocal rentalServicesLocal;
	private DataModel<CarType> carTypeDataModel = new ListDataModel<>();
	private List<CarType> carTypes = new ArrayList<>();
	private CarType carType = new CarType();
	private Boolean visibility = false;

	public String doListSelect() {
		visibility = true;
		return "";
	}

	public CarTypeBean() {
		// TODO Auto-generated constructor stub
	}

	public CarType getCartypeByName(String value) {
		return rentalServicesLocal.findCarTypeByName(value);
	}

	public String doSelect() {
		System.out.println("visibility=   " + visibility);
		return "";
	}

	public String doCreateType() {
		rentalServicesLocal.addCarType(carType);
		return "";
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public DataModel<CarType> getCarTypeDataModel() {
		carTypeDataModel.setWrappedData(this.getCarTypes());
		return carTypeDataModel;
	}

	public void setCarTypeDataModel(DataModel<CarType> carTypeDataModel) {
		this.carTypeDataModel = carTypeDataModel;
	}

	public List<CarType> getCarTypes() {
		carTypes = rentalServicesLocal.findAllCarTypes();
		return carTypes;
	}

	public void setCarTypes(List<CarType> carTypes) {
		this.carTypes = carTypes;
	}

	public Boolean getVisibility() {
		return visibility;
	}

	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

}
