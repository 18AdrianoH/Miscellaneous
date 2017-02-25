package images;
/**
 * @author Adriano Hernandez
 * @version 1.0 alpha
 * @date 11 September 2016
 ****************************
 * An image abstract.
 */
public abstract class Image extends javafx.scene.image.Image{

	//H x W
	private double $height;
	private double $width;
	
	public Image(String arg0) {
		super(arg0);
		$height = this.getHeight();
		$width = this.getWidth();
	}
	//get
	public double height(){
		return $height;
	}
	public double width(){
		return $width;
	}
	//resizeable
	public double setHeight(double $arg0){
		return this.$height = $arg0;
	}
	public double setWidth(double $arg0){
		return this.$width = $arg0;
	}
}
