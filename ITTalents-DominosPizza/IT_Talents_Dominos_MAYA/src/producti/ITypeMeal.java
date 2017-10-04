package producti;

public interface ITypeMeal {

	public enum TypePizza implements ITypeMeal {
		MEAT_PIZZA, VEGETARIAN_PIZZA, SPICY_PIZZA;
	}

	public enum TypeSalad implements ITypeMeal {
		 VEGETARIAN_SALAD, MEAT_SALAD;
	}
	public enum TypeAppetizer implements ITypeMeal {
		 ALL;
	}
	public enum TypeChicken implements ITypeMeal {
		SPICY, NO_SPICY;
	}
	public enum TypePasta implements ITypeMeal {
		SPICY, NO_SPICY;
	}
	
	public enum TypeSause implements ITypeMeal {
		TOMATO_DIP, MILK_DIP, RANCH_DIP, CEZAR_DIP, FRANKS_SPISY_DIP, HANEY_AND_MUSTARD_DIP, GARLIC_AND_HURB_DIP, BBQ_DIP, SWEET_CHILLI_DIP;
	}
	
	
}
