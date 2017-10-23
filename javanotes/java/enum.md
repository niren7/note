[TOC]

# 特点

```java
public enum Explore {
HERE, THERE
}
```

反编译得到

```java
public final class Explore extends java.lang.Enum {
public static final Explore HERE;
public static final Explore THERE;
public static Explore[] values();
public static Explore valueOf(java.lang.String);
static {};
}
```

**定义一个枚举的时候实际上是创建了一个继承自Emum的类**

**每一个枚举实例对应的都是新类中的static final 变量**


valueOf(String) 从String**构造**枚举类型

values() 返回一个由枚举对象构成的数组

静态初始化器 static{}，用来初始化枚举实例，和枚举实例数组，也就是 values（）返回数组

java.lang.Enum中有一个变量private final int ordinal描述枚举类型被声明的顺序

java.lang.Enum的构造方法

```java
protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
```

# 使用

枚举要写在最前面，否则编译出错

## 最简单的枚举

封装了大量细节，枚举Season继承java.lang.Enum，并且会被声明为static final

枚举实例为Season的实例，也被声明为static final

```java
public enum Season {
	SPRING,SUMMER,AUTUMN,WINTER;
}
```

## 带有属性和构造器的枚举

**构造默认也只能是private**

```java
public enum TrafficLamp {
	
	RED(30),YELLOW(30),GREEN(5);
	
	private TrafficLamp() {}
	
	private TrafficLamp(int time){
		this.time = time;
	}
	
	private int time;
}
```

## 覆盖枚举的方法

这种情况下编译器会采用匿名内部类的形式创建枚举实例

```java
public enum EnumTest {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6) {
        @Override
        public boolean isRest() {
            return true;
        }
    },
    SUN(0) {
        @Override
        public boolean isRest() {
            return true;
        }
    }; 
    public boolean isRest() {
        return false;
    }
}
```

## 实现带有抽象方法的枚举

```java
public enum TrafficLamp {
	
	RED(30){
		@Override
		public TrafficLamp nextLamp() {
			return GREEN;
		}
	},
	YELLOW(30){
		@Override
		public TrafficLamp nextLamp() {
			return RED;
		}
	},
	GREEN(5){
		@Override
		public TrafficLamp nextLamp() {
			return YELLOW;
		}
	};
	
	private TrafficLamp() {}
	
	private TrafficLamp(int time){
		this.time = time;
	}
	
	private int time;
	
	public abstract TrafficLamp nextLamp();
}

}
```

# 高级特性

禁止了基础的序列化方法，调用readObject（）和writeObject（）时抛出异常

禁止克隆

单例枚举可以防止反射攻击





















