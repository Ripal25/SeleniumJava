package wrappers;

public interface wrappers {
	
	public void invokeApp(String browser, String url);

	public void enterById(String IdVal, String data);

	public void enterByName(String NameVal, String data) throws InterruptedException;

	public void enterByXPath(String xpathVal, String data) throws InterruptedException;

	public void clickById(String IdVal);

	public void clickByName(String NameVal);

	public void clickByXPath(String xpathVal)throws InterruptedException;
	
	public void clickByCssselVal(String cssselVal);

	public void selectVisibleTextById(String IdVal, String data);

	public void selectValueById(String IdVal, String data);

	public void selectIndexById(String IdVal, int index);

	public void selectVisibleTextByName(String NameVal, String data);

	public void selectValueByName(String NameVal, String data);

	public void selectIndexByName(String NameVal, int index);

	public void selectVisibleTextByXPath(String xpathVal, String data);

	public void selectValueByXPath(String xpathVal, String data);

	public void selectIndexByXPath(String xpathVal, int index);
	
	public void waitDriver(long time);
	
	public void closeDriver();



}
