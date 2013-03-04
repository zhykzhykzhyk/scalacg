package tests

object AbstractTypes2 {
  val c:C = new C{
    type T = List[U]
    val element = List("pie", "ces o", "f a st", "ring")
  }
  { "C.foo"; c }.foo();  
  
  abstract class A {
    type T
    val element: T
  }
  
  abstract class B extends A {
    type U
    type T <: List[U]
    @target("B.foo") def foo(): U
  }
  
  abstract class C extends B {
    type U = String
    @target("C.foo") override def foo(): U = element.foldRight("")((s, t) => s + t)
  }
  
  abstract class D extends B {
    type U = Int
    @target("D.foo") override def foo(): U = element.length
  }
  
  abstract class E extends D {
    @target("E.foo") override def foo(): U = element.count((u) => u > 0)
  }
}