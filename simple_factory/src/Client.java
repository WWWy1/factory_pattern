//�����ƷShape
abstract class Shape{
	public void draw(){};
	public void erase(){};
}
//�����ƷCircle
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
//�����ƷRectangle 
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
//�����ƷTriangle
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
//����
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
				throw new UnsupportedShapeException("��֧�ֻ��ƴ�ͼ��");
		}
	}
}

//�Զ����쳣��
class UnsupportedShapeException extends RuntimeException{
	public UnsupportedShapeException(String message){
		super(message);
	}
}

//�ͻ��˲�����
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
