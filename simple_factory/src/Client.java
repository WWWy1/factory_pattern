//抽象产品Shape
abstract class Shape{
	public void draw(){};
	public void erase(){};
}
//具体产品Circle
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("draw a Circle");
	}
	@Override
	public void erase() {
		System.out.println("erase a Circle");
	}
}
//具体产品Rectangle 
class Rectangle extends Shape{
	@Override
	public void draw() {
		System.out.println("draw a Rectangle");
	}
	@Override
	public void erase() {
		System.out.println("erase a Rectangle");
	}
}
//具体产品Triangle
class Triangle extends Shape{
	@Override
	public void draw() {
		System.out.println("draw a Triangle");
	}
	@Override
	public void erase() {
		System.out.println("erase a Triangle");
	}
}
//工厂
class ShapeFactory
{
	public static Shape createShape(String type) {
		switch(type){
			case "circle":
				return new Circle();
			case "rectangle":
				return new Rectangle();
			case "triangle":
				return new Triangle();
			default:
				throw new UnsupportedShapeException("不支持绘制此图形");
		}
	}
}

//自定义异常类
class UnsupportedShapeException extends RuntimeException{
	public UnsupportedShapeException(String message){
		super(message);
	}
}

//客户端测试类
class Client
{
	public static void main(String[] args)
	{
         try
         {
         	Shape shape;
         	shape=ShapeFactory.createShape("circle");
         	shape.draw();
         	shape.erase();
         }
         catch(UnsupportedShapeException e)
         {
         	System.out.println(e.getMessage());
         }
	}
}
