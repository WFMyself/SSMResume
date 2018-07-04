赢在面试之Java基础篇（1） 		             	             
1、一个".java"源文件中是否可以包括多个类（不是内部类）？有什么限制？

        可以有多个类，但只能有一个public的类，并且public的类名必须与文件名相一致。

2、Java有没有goto?

        java中的保留字，现在没有在java中使用。l

3、说说&和&&的区别。

        &和&&都可以用作逻辑与的运算符，表示逻辑与（and），当运算符两边的表达式的结果都为true时，整个运算结果才为true，否则，只要有一方为false，则结果为false。

        &&还具有短路的功能，即如果第一个表达式为false，则不再计算第二个表达式，例如，对于if(str!= null&& !str.equals(s))表达式，当str为null时，后面的表达式不会执行，所以不会出现NullPointerException如果将&&改为&，则会抛出NullPointerException异常。If(x==33 &++y>0) y会增长，If(x==33 && ++y>0)不会增长

        &还可以用作位运算符，当&操作符两边的表达式不是boolean类型时，&表示按位与操作，我们通常使用0x0f来与一个整数进行&运算，来获取该整数的最低4个bit位，例如，0x31 & 0x0f的结果为0x01。

4、在JAVA中如何跳出当前的多重嵌套循环？

        在Java中，要想跳出多重循环，可以在外面的循环语句前定义一个标号，然后在里层循环体的代码中使用带有标号的break语句，即可跳出外层循环。

例如：

for(int i=0;i<10;i++){
    for(intj=0;j<10;j++){
        System.out.println(“i=” + i + “,j=” + j);
        if(j == 5) break ok;
    }
 }

        另外，我个人通常并不使用标号这种方式，而是让外层的循环条件表达式的结果可以受到里层循环体代码的控制，例如，要在二维数组中查找到某个数字。

int arr[][] =1,2,3},{4,5,6,7},{9;

boolean found = false;

for(int i=0;i<arr.length&&!found;i++)       {

        for(intj=0;j<arr[i].length;j++){

              System.out.println(“i=” + i + “,j=” + j);

              if(arr[i][j] ==5) {

                      found =true;

                      break;

              }

        }

}

5、switch语句能否作用在byte上，能否作用在long上，能否作用在String上?

        在switch（e）中，e只能是一个整数表达式或者枚举常量（更大字体），整数表达式可以是int基本类型或Integer包装类型，由于byte,short,char都可以隐含转换为int，所以，这些类型以及这些类型的包装类型也是可以的。显然，long和String类型都不符合switch的语法规定，并且不能被隐式转换成int类型，所以，它们不能作用于swtich语句中。

6、short s1= 1; s1 = （s1+1是int类型，而等号左边的是short类型，所以需要强转）1 + 1;有什么错? short s1 = 1; s1 += 1;有什么错?(没有错)

        对于short s1= 1; s1 = s1 + 1;由于s1+1运算时会自动提升表达式的类型，所以结果是int型，再赋值给short类型s1时，编译器将报告需要强制转换类型的错误。

        对于short s1= 1; s1 += 1;由于 +=是java语言规定的运算符，java编译器会对它进行特殊处理，因此可以正确编译。

7、char型变量中能不能存贮一个中文汉字?为什么?

        char型变量是用来存储Unicode编码的字符的，unicode编码字符集中包含了汉字，所以，char型变量中当然可以存储汉字啦。不过，如果某个特殊的汉字没有被包含在unicode编码字符集中，那么，这个char型变量中就不能存储这个特殊汉字。补充说明：unicode编码占用两个字节，所以，char类型的变量也是占用两个字节。

8、用最有效率的方法算出2乘以8等於几?

        2<< 3，(左移三位)因为将一个数左移n位，就相当于乘以了2的n次方，那么，一个数乘以8只要将其左移3位即可，而位运算cpu直接支持的，效率最高，所以，2乘以8等於几的最效率的方法是2<< 3。

9、使用final关键字修饰一个变量时，是引用不能变，还是引用的对象不能变？

        使用final关键字修饰一个变量时，是指引用变量不能变，引用变量所指向的对象中的内容还是可以改变的。例如，对于如下语句：

 finalStringBuffer a=new StringBuffer("immutable");
执行如下语句将报告编译期错误：

a=new StringBuffer("");
但是，执行如下语句则可以通过编译：

a.append(" broken!");

有人在定义方法的参数时，可能想采用如下形式来阻止方法内部修改传进来的参数对象：

public void method(final  StringBuffer param){

}

实际上，这是办不到的，在该方法内部仍然可以增加如下代码来修改参数对象：

        param.append("a");

10，静态变量和实例变量的区别？

        在语法定义上的区别：静态变量前要加static关键字，而实例变量前则不加。

        在程序运行时的区别：实例变量属于某个对象的属性，必须创建了实例对象，其中的实例变量才会被分配空间，才能使用这个实例变量。静态变量不属于某个实例对象，而是属于类，所以也称为类变量，只要程序加载了类的字节码，不用创建任何实例对象，静态变量就会被分配空间，静态变量就可以被使用了。总之，实例变量必须创建对象后才可以通过这个对象来使用，静态变量则可以直接使用类名来引用。

        例如，对于下面的程序，无论创建多少个实例对象，永远都只分配了一个staticVar变量，并且每创建一个实例对象，这个staticVar就会加1；但是，每创建一个实例对象，就会分配一个instanceVar，即可能分配多个instanceVar，并且每个instanceVar的值都只自加了1次。

public class VariantTest{

        publicstatic int staticVar = 0;

        publicint instanceVar = 0;

        publicVariantTest(){

              staticVar++;

              instanceVar++;

              System.out.println(staticVar +instanceVar);

        }

}
赢在面试之Java基础篇（2） 		             	             

11、是否可以从一个static方法内部发出对非static方法的调用？

        不可以。因为非static方法是要与对象关联在一起的，必须创建一个对象后，才可以在该对象上进行方法调用，而static方法调用时不需要创建对象，可以直接调用。也就是说，当一个static方法被调用时，可能还没有创建任何实例对象，如果从一个static方法中发出对非static方法的调用，那个非static方法是关联到哪个对象上的呢？这个逻辑无法成立，所以，一个static方法内部发出对非static方法的调用。

12、Integer与int的区别

        int是java提供的8种原始数据类型之一。Java为每个原始类型提供了封装类，Integer是java为int提供的封装类。int的默认值为0，而Integer的默认值为null，即Integer可以区分出未赋值和值为0的区别，int则无法表达出未赋值的情况。

        例如：要想表达出没有参加考试和考试成绩为0的区别，则只能使用Integer。在JSP开发中，Integer的默认为null，所以用el表达式在文本框中显示时，值为空白字符串，而int默认的默认值为0，所以用el表达式在文本框中显示时，结果为0，所以，int不适合作为web层的表单数据的类型。

        在Hibernate中，如果将OID定义为Integer类型，那么Hibernate就可以根据其值是否为null而判断一个对象是否是临时的，如果将OID定义为了int类型，还需要在hbm映射文件中设置其unsaved-value属性为0。

        另外，Integer提供了多个与整数相关的操作方法，例如，将一个字符串转换成整数，Integer中还定义了表示整数的最大值和最小值的常量。

13、Math.round(11.5)等於多少?Math.round(-11.5)等於多少?

        Math类中提供了三个与取整有关的方法：ceil、floor、round，这些方法的作用与它们的英文名称的含义相对应。

        例如，ceil的英文意义是天花板，该方法就表示向上取整，Math.ceil(11.3)的结果为12,Math.ceil(-11.3)的结果是-11；floor的英文意义是地板，该方法就表示向下取整，Math.ceil(11.6)的结果为11,Math.ceil(-11.6)的结果是-12；最难掌握的是round方法，它表示“四舍五入”，算法为Math.floor(x+0.5)，即将原来的数字加上0.5后再向下取整，所以，Math.round(11.5)的结果为12，Math.round(-11.5)的结果为-11。


 

14、Overload和Override的区别？Overloaded的方法是否可以改变返回值的类型?

        Overload是重载的意思，Override是覆盖的意思，也就是重写。

        重载Overload表示同一个类中可以有多个名称相同的方法，但这些方法的参数列表各不相同（即参数个数或类型不同）。

        重写Override表示子类中的方法可以与父类中的某个方法的名称和参数完全相同，通过子类创建的实例对象调用这个方法时，将调用子类中的定义方法，这相当于把父类中定义的那个完全相同的方法给覆盖了，这也是面向对象编程的多态性的一种表现。子类覆盖父类的方法时，只能比父类抛出更少的异常，或者是抛出父类抛出的异常的子异常，因为子类可以解决父类的一些问题，不能比父类有更多的问题。子类方法的访问权限只能比父类的更大，不能更小。如果父类的方法是private类型，那么，子类则不存在覆盖的限制，相当于子类中增加了一个全新的方法。

        至于Overloaded的方法是否可以改变返回值的类型这个问题，要看你倒底想问什么呢？这个题目很模糊。如果几个Overloaded的方法的参数列表不一样，它们的返回者类型当然也可以不一样。但我估计你想问的问题是：如果两个方法的参数列表完全一样，是否可以让它们的返回值不同来实现重载Overload。这是不行的，我们可以用反证法来说明这个问题，因为我们有时候调用一个方法时也可以不定义返回结果变量，即不要关心其返回结果，例如，我们调用map.remove(key)方法时，虽然remove方法有返回值，但是我们通常都不会定义接收返回结果的变量，这时候假设该类中有两个名称和参数列表完全相同的方法，仅仅是返回类型不同，java就无法确定编程者倒底是想调用哪个方法了，因为它无法通过返回结果类型来判断。

        override可以翻译为覆盖，从字面就可以知道，它是覆盖了一个方法并且对其重写，以求达到不同的作用。对我们来说最熟悉的覆盖就是对接口方法的实现，在接口中一般只是对方法进行了声明，而我们在实现时，就需要实现接口声明的所有方法。除了这个典型的用法以外，我们在继承中也可能会在子类覆盖父类中的方法。在覆盖要注意以下的几点：

        1、覆盖的方法的标志必须要和被覆盖的方法的标志完全匹配，才能达到覆盖的效果；

        2、覆盖的方法的返回值必须和被覆盖的方法的返回一致；

        3、覆盖的方法所抛出的异常必须和被覆盖方法的所抛出的异常一致，或者是其子类；

        4、被覆盖的方法不能为private，否则在其子类中只是新定义了一个方法，并没有对其进行覆盖。

        Overload对我们来说可能比较熟悉，可以翻译为重载，它是指我们可以定义一些名称相同的方法，通过定义不同的输入参数来区分这些方法，然后再调用时，VM就会根据不同的参数样式，来选择合适的方法执行。在使用重载要注意以下的几点：

        1、在使用重载时只能通过不同的参数样式。例如，不同的参数类型，不同的参数个数，不同的参数顺序（当然，同一方法内的几个参数类型必须不一样，例如可以是fun(int,float)，但是不能为fun(int,int)）；

        2、不能通过访问权限、返回类型、抛出的异常进行重载；

        3、方法的异常类型和数目不会对重载造成影响；

        4、对于继承来说，如果某一方法在父类中是访问权限是priavte，那么就不能在子类对其进行重载，如果定义的话，也只是定义了一个新方法，而不会达到重载的效果。

15、接口是否可继承接口?抽象类是否可实现(implements)接口?抽象类是否可继承具体类(concreteclass)?抽象类中是否可以有静态的main方法？

        接口可以继承接口。抽象类可以实现(implements)接口，抽象类可以继承具体类。抽象类中可以有静态的main方法。

        备注：只要明白了接口和抽象类的本质和作用，这些问题都很好回答，你想想，如果你是java语言的设计者，你是否会提供这样的支持，如果不提供的话，有什么理由吗？如果你没有道理不提供，那答案就是肯定的了。

        只要记住抽象类与普通类的唯一区别就是不能创建实例对象和允许有abstract方法。

16、Java中实现多态的机制是什么？

        靠的是父类或接口定义的引用变量可以指向子类或具体实现类的实例对象，而程序调用的方法在运行期才动态绑定，就是引用变量所指向的具体实例对象的方法，也就是内存里正在运行的那个对象的方法，而不是引用变量的类型中定义的方法。

17、abstractclass和interface语法上有什么区别?

1.抽象类可以有构造方法，接口中不能有构造方法。

2.抽象类中可以有普通成员变量，接口中没有普通成员变量

3.抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方法。

4. 抽象类中的抽象方法的访问类型可以是public，protected和（默认类型,虽然

eclipse下不报错，但应该也不行），但接口中的抽象方法只能是public类型的，并且默认即为public abstract类型。

5. 抽象类中可以包含静态方法，接口中不能包含静态方法

6. 抽象类和接口中都可以包含静态成员变量，抽象类中的静态成员变量的访问类型可以任意，但接口中定义的变量只能是publicstatic final类型，并且默认即为publicstatic final类型。

7. 一个类可以实现多个接口，但只能继承一个抽象类。

18、abstract的method是否可同时是static,是否可同时是native，是否可同时是synchronized?

        abstract的method不可以是static的，因为抽象的方法是要被子类实现的，而static与子类扯不上关系！

        native方法表示该方法要用另外一种依赖平台的编程语言实现的，不存在着被子类实现的问题，所以，它也不能是抽象的，不能与abstract混用。例如，FileOutputSteam类要硬件打交道，底层的实现用的是操作系统相关的api实现；例如，在windows用c语言实现的，所以，查看jdk的源代码，可以发现FileOutputStream的open方法的定义如下：

private native void open(Stringname) throwsFileNotFoundException;

        如果我们要用java调用别人写的c语言函数，我们是无法直接调用的，我们需要按照java的要求写一个c语言的函数，又我们的这个c语言函数去调用别人的c语言函数。由于我们的c语言函数是按java的要求来写的，我们这个c语言函数就可以与java对接上，java那边的对接方式就是定义出与我们这个c函数相对应的方法，java中对应的方法不需要写具体的代码，但需要在前面声明native。

        关于synchronized与abstract合用的问题，我觉得也不行，因为在我几年的学习和开发中，从来没见到过这种情况，并且我觉得synchronized应该是作用在一个具体的方法上才有意义。而且，方法上的synchronized同步所使用的同步锁对象是this，而抽象方法上无法确定this是什么。

19、内部类可以引用它的包含类的成员吗？有没有什么限制？

        完全可以。如果不是静态内部类，那没有什么限制！

        如果你把静态嵌套类当作内部类的一种特例，那在这种情况下不可以访问外部类的普通成员变量，而只能访问外部类中的静态成员，例如，下面的代码：

class Outer

{

static int x;

static class Inner

    {

        voidtest()

        {

              syso(x);

        }

    }

}

20、String s = "Hello";s = s + "world!";这两行代码执行后，原始的String对象中的内容到底变了没有？

        没有。因为String被设计成不可变(immutable)类，所以它的所有对象都是不可变对象。在这段代码中，s原先指向一个String对象，内容是 "Hello"，然后我们对s进行了+操作，那么s所指向的那个对象是否发生了改变呢？答案是没有。这时，s不指向原来那个对象了，而指向了另一个 String对象，内容为"Hello world!"，原来那个对象还存在于内存之中，只是s这个引用变量不再指向它了。

        通过上面的说明，我们很容易导出另一个结论，如果经常对字符串进行各种各样的修改，或者说，不可预见的修改，那么使用String来代表字符串的话会引起很大的内存开销。因为String对象建立之后不能再改变，所以对于每一个不同的字符串，都需要一个String对象来表示。这时，应该考虑使用StringBuffer类，它允许修改，而不是每个不同的字符串都要生成一个新的对象。并且，这两种类的对象转换十分容易。
        同时，我们还可以知道，如果要使用内容相同的字符串，不必每次都new一个String。例如我们要在构造器中对一个名叫s的String引用变量进行初始化，把它设置为初始值，应当这样做：
public class Demo {
 private String s;
 ...
 public Demo {
 s = "Initial Value";
 }
 ...
 }
而非
s = new String("Initial Value");
后者每次都会调用构造器，生成新对象，性能低下且内存开销大，并且没有意义，因为String对象不可改变，所以对于内容相同的字符串，只要一个String对象来表示就可以了。也就说，多次调用上面的构造器创建多个对象，他们的            String类型属性s都指向同一个对象。
 上面的结论还基于这样一个事实：对于字符串常量，如果内容相同，Java认为它们代表同一个String对象。而用关键字new调用构造器，总是会创建一个新的对象，无论内容是否相同。
        至于为什么要把String类设计成不可变类，是它的用途决定的。其实不只String，很多Java标准类库中的类都是不可变的。在开发一个系
	 
赢在面试之Java集合框架篇（3）   
 


21、ArrayList和Vector的区别

        这两个类都实现了List接口（List接口继承了Collection接口），他们都是有序集合，即存储在这两个集合中的元素的位置都是有顺序的，相当于一种动态的数组，我们以后可以按位置索引号取出某个元素，并且其中的数据是允许重复的，这是与HashSet之类的集合的最大不同处，HashSet之类的集合不可以按索引号去检索其中的元素，也不允许有重复的元素。

         ArrayList与Vector的区别主要包括两个方面：.
（1）同步性：

       Vector是线程安全的，也就是说是它的方法之间是线程同步的，而ArrayList是线程序不安全的，它的方法之间是线程不同步的。如果只有一个线程会访问到集合，那最好是使用ArrayList，因为它不考虑线程安全，效率会高些；如果有多个线程会访问到集合，那最好是使用Vector，因为不需要我们自己再去考虑和编写线程安全的代码。

（2）数据增长：

       ArrayList与Vector都有一个初始的容量大小，当存储进它们里面的元素的个数超过了容量时，就需要增加ArrayList与Vector的存储空间，每次要增加存储空间时，不是只增加一个存储单元，而是增加多个存储单元，每次增加的存储单元的个数在内存空间利用与程序效率之间要取得一定的平衡。Vector默认增长为原来两倍，而ArrayList的增长策略在文档中没有明确规定（从源代码看到的是增长为原来的1.5倍）。ArrayList与Vector都可以设置初始的空间大小，Vector还可以设置增长的空间大小，而ArrayList没有提供设置增长空间的方法。

    总结：即Vector增长原来的一倍，ArrayList增加原来的0.5倍。




22、HashMap和Hashtable的区别

        HashMap是Hashtable的轻量级实现（非线程安全的实现），他们都完成了Map接口，主要区别在于HashMap允许空（null）键值（key）,由于非线程安全，在只有一个线程访问的情况下，效率要高于Hashtable。

        HashMap允许将null作为一个entry的key或者value，而Hashtable不允许。

HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。

        Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现。

        最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap就必须为之提供同步。

     就HashMap与HashTable主要从三方面来说。
        一.历史原因:Hashtable是基于陈旧的Dictionary类的，HashMap是Java 1.2引进的Map接口的一个实现
        二.同步性:Hashtable是线程安全的，也就是说是同步的，而HashMap是线程序不安全的，不是同步的
        三.值：只有HashMap可以让你将空值作为一个表的条目的key或value




23、List和 Map区别?

        一个是存储单列数据的集合，另一个是存储键和值这样的双列数据的集合，List中存储的数据是有顺序，并且允许重复；Map中存储的数据是没有顺序的，其键是不能重复的，它的值是可以有重复的。




24、List,Set, Map是否继承自Collection接口?

   List，Set是，Map不是

 

25、List、Map、Set三个接口，存取元素时，各有什么特点？

（这样的题比较考水平，两个方面的水平：一是要真正明白这些内容，二是要有较强的总结和表述能力。）

        首先，List与Set具有相似性，它们都是单列元素的集合，所以，它们有一个共同的父接口，叫Collection。Set里面不允许有重复的元素，即不能有两个相等（注意，不是仅仅是相同）的对象，即假设Set集合中有了一个A对象，现在我要向Set集合再存入一个B对象，但B对象与A对象equals相等，则B对象存储不进去，所以，Set集合的add方法有一个boolean的返回值，当集合中没有某个元素，此时add方法可成功加入该元素时，则返回true，当集合含有与某个元素equals相等的元素时，此时add方法无法加入该元素，返回结果为false。Set取元素时，不能细说要取第几个，只能以Iterator接口取得所有的元素，再逐一遍历各个元素。

       List表示有先后顺序的集合，注意，不是那种按年龄、按大小、按价格之类的排序。当我们多次调用add(Obje)方法时，每次加入的对象就像火车站买票有排队顺序一样，按先来后到的顺序排序。有时候，也可以插队，即调用add(intindex,Obj e)方法，就可以指定当前对象在集合中的存放位置。一个对象可以被反复存储进List中，每调用一次add方法，这个对象就被插入进集合中一次，其实，并不是把这个对象本身存储进了集合中，而是在集合中用一个索引变量指向这个对象，当这个对象被add多次时，即相当于集合中有多个索引指向了这个对象，如图x所示。List除了可以用Iterator接口取得所有的元素，再逐一遍历各个元素之外，还可以调用get(index i)来明确说明取第几个。

       Map与List和Set不同，它是双列的集合，其中有put方法，定义如下：put(obj key,obj value)，每次存储时，要存储一对key/value，不能存储重复的key，这个重复的规则也是按equals比较相等。取则可以根据key获得相应的value，即get(Object key)返回值为key所对应的value。另外，也可以获得所有的key的结合，还可以获得所有的value的结合，还可以获得key和value组合成的Map.Entry对象的集合。

 List以特定次序来持有元素，可有重复元素。Set无法拥有重复元素,内部排序。Map保存key-value值，value可多值。




26、说出ArrayList,Vector,LinkedList的存储性能和特性

        ArrayList和Vector都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢，Vector由于使用了synchronized方法（线程安全），通常性能上较ArrayList差。而LinkedList使用双向链表实现存储，按序号索引数据需要进行前向或后向遍历，索引就变慢了，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。

        LinkedList也是线程不安全的，LinkedList提供了一些方法，使得LinkedList可以被当作堆栈和队列来使用。




27、去掉一个Vector集合中重复的元素

Vector newVector = new Vector();

For (int i=0;i<vector.size();i++)

{

Object obj = vector.get(i);

       if(!newVector.contains(obj);

             newVector.add(obj);

}

还有一种简单的方式，利用了Set不允许重复元素：

HashSetset = new HashSet(vector);




28、Collection和Collections的区别。

        Collection是集合类的上级接口，继承他的接口主要有Set和List.

        Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。




29、Set里的元素是不能重复的，那么用什么方法来区分重复与否呢?是用==还是equals()?它们有何区别?

        Set里的元素是不能重复的，元素重复与否是使用equals()方法进行判断的。

        ==和equal区别也是考烂了的题，这里说一下：

        ==操作符专门用来比较两个变量的值是否相等，也就是用于比较变量所对应的内存中所存储的数值是否相同，要比较两个基本类型的数据或两个引用变量是否相等，只能用==操作符。

        equals方法是用于比较两个独立对象的内容是否相同，就好比去比较两个人的长相是否相同，它比较的两个对象是独立的。 


        比如：两条new语句创建了两个对象，然后用a/b这两个变量分别指向了其中一个对象，这是两个不同的对象，它们的首地址是不同的，即a和b中存储的数值是不相同的，所以，表达式a==b将返回false，而这两个对象中的内容是相同的，所以，表达式a.equals(b)将返回true。


30、你所知道的集合类都有哪些？主要方法？

        最常用的集合类是 List 和 Map。 List的具体实现包括 ArrayList和 Vector，它们是可变大小的列表，比较适合构建、存储和操作任何类型对象的元素列表。 List适用于按数值索引访问元素的情形。

        Map 提供了一个更通用的元素存储方法。 Map集合类用于存储元素对（称作"键"和"值"），其中每个键映射到一个值。

        它们都有增删改查的方法。

        对于set，大概的方法是add,remove, contains等

        对于map，大概的方法就是put,remove，contains等

        List类会有get(int index)这样的方法，因为它可以按顺序取元素，而set类中没有get(int index)这样的方法。List和set都可以迭代出所有元素，迭代时先要得到一个iterator对象，所以，set和list类都有一个iterator方法，用于返回那个iterator对象。map可以返回三个集合，一个是返回所有的key的集合，另外一个返回的是所有value的集合，再一个返回的key和value组合成的EntrySet对象的集合，map也有get方法，参数是key，返回值是key对应的value，这个自由发挥，也不是考记方法的能力，这些编程过程中会有提示，结合他们三者的不同说一下用法就行。
      
赢在面试之Java基础篇（4）   
 
31、String s = new String("xyz");创建了几个StringObject？是否可以继承String类?

        两个或一个都有可能，”xyz”对应一个对象，这个对象放在字符串常量缓冲区，常量”xyz”不管出现多少遍，都是缓冲区中的那一个。NewString每写一遍，就创建一个新的对象，它使用常量”xyz”对象的内容来创建出一个新String对象。如果以前就用过’xyz’，那么这里就不会创建”xyz”了，直接从缓冲区拿，这时创建了一个StringObject；但如果以前没有用过"xyz"，那么此时就会创建一个对象并放入缓冲区，这种情况它创建两个对象。至于String类是否继承，答案是否定的，因为String默认final修饰，是不可继承的。


32、String和StringBuffer的区别

        JAVA平台提供了两个类：String和StringBuffer，它们可以储存和操作字符串，即包含多个字符的字符数据。这个String类提供了数值不可改变的字符串。而这个StringBuffer类提供的字符串可以进行修改。当你知道字符数据要改变的时候你就可以使用StringBuffer。典型地，你可以使用StringBuffers来动态构造字符数据。

      


33、下面这条语句一共创建了多少个对象：String s="a"+"b"+"c"+"d";


对于如下代码：

String s1 = "a";

String s2 = s1 + "b";

String s3 = "a" + "b";

System.out.println(s2 == "ab");

System.out.println(s3 == "ab");

第一条语句打印的结果为false，第二条语句打印的结果为true，这说明javac编译可以对字符串常量直接相加的表达式进行优化，不必要等到运行期再去进行加法运算处理，而是在编译时去掉其中的加号，直接将其编译成一个这些常量相连的结果。

题目中的第一行代码被编译器在编译时优化后，相当于直接定义了一个”abcd”的字符串，所以，上面的代码应该只创建了一个String对象。写如下两行代码，

          String s ="a" + "b" +"c" + "d";

          System.out.println(s== "abcd");

最终打印的结果应该为true。

34、try {}里有一个return语句，那么紧跟在这个try后的finally{}里的code会不会被执行，什么时候被执行，在return前还是后?

        我们知道finally{}中的语句是一定会执行的，那么这个可能正常脱口而出就是return之前，return之后可能就出了这个方法了，鬼知道跑哪里去了，但更准确的应该是在return中间执行，请看下面程序代码的运行结果：
public classTest {

    public static void main(String[]args) {
       System.out.println(newTest().test());;
    }
    static int test()
    {
       intx = 1;
       try
       {
        returnx;

       }

       finally

       {

          ++x;
       }
    } 
}

 

---------执行结果 ---------

1

运行结果是1，为什么呢？主函数调用子函数并得到结果的过程，好比主函数准备一个空罐子，当子函数要返回结果时，先把结果放在罐子里，然后再将程序逻辑返回到主函数。所谓返回，就是子函数说，我不运行了，你主函数继续运行吧，这没什么结果可言，结果是在说这话之前放进罐子里的。




35、final, finally, finalize的区别。 


        final 用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，类不可继承。内部类要访问局部变量，局部变量必须定义成final类型。

        finally是异常处理语句结构的一部分，表示总是执行。

        finalize是Object类的一个方法，在垃圾收集器执行的时候会调用被回收对象的此方法，可以覆盖此方法提供垃圾收集时的其他资源回收，例如关闭文件等。但是JVM不保证此方法总被调用



36、运行时异常与一般异常有何异同？

        异常表示程序运行过程中可能出现的非正常状态，运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误。java编译器要求方法必须声明抛出可能发生的非运行时异常，但是并不要求必须声明抛出未被捕获的运行时异常。


37、error和exception有什么区别?

        error 表示恢复不是不可能但很困难的情况下的一种严重问题。比如说内存溢出。不可能指望程序能处理这样的情况。exception表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。

38、简单说说Java中的异常处理机制的简单原理和应用。

        异常是指java程序运行时（非编译）所发生的非正常情况或错误，与现实生活中的事件很相似，现实生活中的事件可以包含事件发生的时间、地点、人物、情节等信息，可以用一个对象来表示，Java使用面向对象的方式来处理异常，它把程序中发生的每个异常也都分别封装到一个对象来表示的，该对象中包含有异常的信息。
        Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为java.lang.Throwable，Throwable下面又派生了两个子类：
        Error和Exception，Error表示应用程序本身无法克服和恢复的一种严重问题，程序只有奔溃了，例如，说内存溢出和线程死锁等系统问题。
        Exception表示程序还能够克服和恢复的问题，其中又分为系统异常和普通异常：
        系统异常是软件本身缺陷所导致的问题，也就是软件开发人员考虑不周所导致的问题，软件使用者无法克服和恢复这种问题，但在这种问题下还可以让软件系统继续运行或者让软件挂掉，例如，数组脚本越界（ArrayIndexOutOfBoundsException），空指针异常（NullPointerException）、类转换异常（ClassCastException）；

        普通异常是运行环境的变化或异常所导致的问题，是用户能够克服的问题，例如，网络断线，硬盘空间不够，发生这样的异常后，程序不应该死掉。

java为系统异常和普通异常提供了不同的解决方案，编译器强制普通异常必须try..catch处理或用throws声明继续抛给上层调用方法处理，所以普通异常也称为checked异常，而系统异常可以处理也可以不处理，所以，编译器不强制用try..catch处理或用throws声明，所以系统异常也称为unchecked异常。

39、Java 中堆和栈有什么区别？
        JVM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个 JVM 的所有线程共享。

        栈：在函数中定义的一些基本类型的变量和对象的引用变量都是在函数的栈内存中分配，当在一段代码块定义一个变量时，Java 就在栈中为这个变量分配内存空间，当超过变量的作用域后，Java 会自动释放掉为该变量分配的内存空间，该内存空间可以立即被另作它用。

        堆：堆内存用来存放由 new 创建的对象和数组，在堆中分配的内存，由 Java 虚拟机的自动垃圾回收器来管理。在堆中产生了一个数组或者对象之后，还可以在栈中定义一个特殊的变量，让栈中的这个变量的取值等于数组或对象在堆内存中的首地址，栈中的这个变量就成了数组或对象的引用变量，以后就可以在程序中使用栈中的引用变量来访问堆中的数组或者对象，引用变量就相当于是为数组或者对象起的一个名称。

40、能将 int 强制转换为 byte 类型的变量吗？如果该值大于 byte 类型的范围，将会出现什么现象？ 
         我们可以做强制转换，但是 Java 中 int 是 32 位的，而 byte 是 8 位的，所以，如果强制转化，int 类型的高 24 位将会被丢弃，因为byte 类型的范围是从 -128 到 128。

赢在面试之Java基础篇（5）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/1TI4h1gakAAA6_SHPM7fxA 


41、a.hashCode() 有什么用？与 a.equals(b) 有什么关系？
        hashCode() 方法对应对象整型的 hash 值。它常用于基于 hash 的集合类，如 Hashtable、HashMap、LinkedHashMap等等。它与 equals() 方法关系特别紧密。根据 Java 规范，两个使用 equal() 方法来判断相等的对象，必须具有相同的 hash code。




42、字节流与字符流的区别

       要把一段二进制数据数据逐一输出到某个设备中，或者从某个设备中逐一读取一段二进制数据，不管输入输出设备是什么，我们要用统一的方式来完成这些操作，用一种抽象的方式进行描述，这个抽象描述方式起名为IO流，对应的抽象类为OutputStream和InputStream，不同的实现类就代表不同的输入和输出设备，它们都是针对字节进行操作的。

       计算机中的一切最终都是二进制的字节形式存在。对于经常用到的中文字符，首先要得到其对应的字节，然后将字节写入到输出流。读取时，首先读到的是字节，可是我们要把它显示为字符，我们需要将字节转换成字符。由于这样的需求很广泛，Java专门提供了字符流包装类。

      底层设备永远只接受字节数据，有时候要写字符串到底层设备，需要将字符串转成字节再进行写入。字符流是字节流的包装，字符流则是直接接受字符串，它内部将串转成字节，再写入底层设备，这为我们向IO设备写入或读取字符串提供了一点点方便。

      字符向字节转换时，要注意编码的问题，因为字符串转成字节数组，其实是转成该字符的某种编码的字节形式，读取也是反之的道理。




43、什么是java序列化，如何实现java序列化？或者请解释Serializable接口的作用。

        我们有时候将一个java对象变成字节流的形式传出去或者从一个字节流中恢复成一个java对象，例如，要将java对象存储到硬盘或者传送给网络上的其他计算机，这个过程我们可以自己写代码去把一个java对象变成某个格式的字节流再传输。

        但是，jre本身就提供了这种支持，我们可以调用OutputStream的writeObject方法来做，如果要让java帮我们做，要被传输的对象必须实现serializable接口，这样，javac编译时就会进行特殊处理，编译的类才可以被writeObject方法操作，这就是所谓的序列化。需要被序列化的类必须实现Serializable接口，该接口是一个mini接口，其中没有需要实现方法，implements Serializable只是为了标注该对象是可被序列化的。

        例如，在web开发中，如果对象被保存在了Session中，tomcat在重启时要把Session对象序列化到硬盘，这个对象就必须实现Serializable接口。如果对象要经过分布式系统进行网络传输，被传输的对象就必须实现Serializable接口。

 

44、描述一下JVM加载class文件的原理机制?

        JVM中类的装载是由ClassLoader和它的子类来实现的,Java ClassLoader是一个重要的Java运行时系统组件。它负责在运行时查找和装入类文件的类。

 

45、heap和stack有什么区别。

        java的内存分为两类，一类是栈内存，一类是堆内存。栈内存是指程序进入一个方法时，会为这个方法单独分配一块私属存储空间，用于存储这个方法内部的局部变量，当这个方法结束时，分配给这个方法的栈会释放，这个栈中的变量也将随之释放。

        堆是与栈作用不同的内存，一般用于存放不在当前方法栈中的那些数据，例如，使用new创建的对象都放在堆里，所以，它不会随方法的结束而消失。方法中的局部变量使用final修饰后，放在堆中，而不是栈中。

 

46、GC是什么?为什么要有GC?

        GC是垃圾收集的意思（Gabage Collection）,内存处理是编程人员容易出现问题的地方，忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃，Java提供的GC功能可以自动监测对象是否超过作用域从而达到自动回收内存的目的，Java语言没有提供释放已分配内存的显示操作方法。

 

47、垃圾回收的优点和原理。并考虑2种回收机制。

        Java语言中一个显著的特点就是引入了垃圾回收机制，使c++程序员最头疼的内存管理的问题迎刃而解，它使得Java程序员在编写程序的时候不再需要考虑内存管理。由于垃圾回收机制，Java中的对象不再有"作用域"的概念，只有对象的引用才有"作用域"。

        垃圾回收可以有效的防止内存泄露，有效的使用可以使用的内存。垃圾回收器通常是作为一个单独的低级别的线程运行，不可预知的情况下对内存堆中已经死亡的或者长时间没有使用的对象进行清除和回收，程序员不能实时的调用垃圾回收器对某个对象或所有对象进行垃圾回收。

        回收机制有分代复制垃圾回收和标记垃圾回收，增量垃圾回收。

 

48、垃圾回收器的基本原理是什么？垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？

        对于GC来说，当程序员创建对象时，GC就开始监控这个对象的地址、大小以及使用情况。通常，GC采用有向图的方式记录和管理堆(heap)中的所有对象。通过这种方式确定哪些对象是"可达的"，哪些对象是"不可达的"。当GC确定一些对象为"不可达"时，GC就有责任回收这些内存空间。

        程序员可以手动执行System.gc()，通知GC运行，但是Java语言规范并不保证GC一定会执行。




49、Java 中，throw 和 throws 有什么区别

        throw 用于抛出 java.lang.Throwable 类的一个实例化对象，意思是说你可以通过关键字 throw 抛出一个Exception，如： 
throw new IllegalArgumentException(“XXXXXXXXX″)

        而throws 的作用是作为方法声明和签名的一部分，方法被抛出相应的异常以便调用者能处理。Java 中，任何未处理的受检查异常强制在 throws 子句中声明。




50，java中会存在内存泄漏吗，请简单描述。

        先解释什么是内存泄漏：所谓内存泄露就是指一个不再被程序使用的对象或变量一直被占据在内存中。java中有垃圾回收机制，它可以保证当对象不再被引用的时候，对象将自动被垃圾回收器从内存中清除掉。

        由于Java使用有向图的方式进行垃圾回收管理，可以消除引用循环的问题，例如有两个对象，相互引用，只要它们和根进程不可达，那么GC也是可以回收它们的。


        java中的内存泄露的情况：长生命周期的对象持有短生命周期对象的引用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不能被回收，这就是java中内存泄露的发生场景，通俗地说，就是程序员可能创建了一个对象，以后一直不再使用这个对象，这个对象却一直被引用，即这个对象无用但是却无法被垃圾回收器回收的，这就是java中可能出现内存泄露的情况，例如，缓存系统，我们加载了一个对象放在缓存中(例如放在一个全局map对象中)，然后一直不再使用它，这个对象一直被缓存引用，但却不再被使用。


赢在面试之JavaWeb篇（6）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/qeXu45Y0WNRkg0z8amWoCQ 

51、说一说Servlet的生命周期?

        Servlet有良好的生存期的定义，包括加载和实例化、初始化、处理请求以及服务结束。这个生存期由javax.servlet.Servlet接口的init(),service()和destroy方法表达。

        Servlet被服务器实例化后，容器运行其init方法，请求到达时运行其service方法，service方法自动派遣运行与请求对应的doXXX方法（doGet，doPost）等，当服务器决定将实例销毁的时候调用其destroy方法。

web容器加载servlet，生命周期开始。通过调用servlet的init()方法进行servlet的初始化。通过调用service()方法实现，根据请求的不同调用不同的do***()方法。结束服务，web容器调用servlet的destroy()方法。




52、Servlet API中forward()与redirect()的区别？

    1.从地址栏显示来说
        forward是服务器请求资源,服务器直接访问目标地址的URL,把那个URL的响应内容读取过来,然后把这些内容再发给浏览器.浏览器根本不知道服务器发送的内容从哪里来的,所以它的地址栏还是原来的地址.
         redirect是服务端根据逻辑,发送一个状态码,告诉浏览器重新去请求那个地址.所以地址栏显示的是新的URL.所以redirect等于客户端向服务器端发出两次request，同时也接受两次response。
    2.从数据共享来说
        forward:转发页面和转发到的页面可以共享request里面的数据.
         redirect:不能共享数据.
         redirect不仅可以重定向到当前应用程序的其他资源,还可以重定向到同一个站点上的其他应用程序中的资源,甚至是使用绝对URL重定向到其他站点的资源.
         forward方法只能在同一个Web应用程序内的资源之间转发请求.forward 是服务器内部的一种操作.
         redirect 是服务器通知客户端,让客户端重新发起请求.
    所以,你可以说 redirect 是一种间接的请求, 但是你不能说"一个请求是属于forward还是redirect "
     3.从运用地方来说
        forward:一般用于用户登陆的时候,根据角色转发到相应的模块.
         redirect:一般用于用户注销登陆时返回主页面和跳转到其它的网站等.
     4.从效率来说
        forward:高.
         redirect:低.




53、request.getAttribute()和 request.getParameter()有何区别?

        1，request.getParameter()取得是通过容器的实现来取得通过类似post，get等方式传入的数据。

            request.setAttribute()和getAttribute()只是在web容器内部流转，仅仅是请求处理阶段。

        2，getAttribute是返回对象,getParameter返回字符串

        3，getAttribute()一向是和setAttribute()一起使用的，只有先用setAttribute()设置之后，才能够通过getAttribute()来获得值，它们传递的是Object类型的数据。而且必须在同一个request对象中使用才有效。,而getParameter()是接收表单的get或者post提交过来的参数




54，jsp静态包含和动态包含的区别

        1、<%@include file="xxx.jsp"%>为jsp中的编译指令，其文件的包含是发生在jsp向servlet转换的时期，而<jsp:include page="xxx.jsp">是jsp中的动作指令，其文件的包含是发生在编译时期，也就是将java文件编译为class文件的时期 


        2、使用静态包含只会产生一个class文件，而使用动态包含会产生多个class文件 


        3、使用静态包含，包含页面和被包含页面的request对象为同一对象，因为静态包含只是将被包含的页面的内容复制到包含的页面中去；而动态包含包含页面和被包含页面不是同一个页面，被包含的页面的request对象可以取到的参数范围要相对大些，不仅可以取到传递到包含页面的参数，同样也能取得在包含页面向下传递的参数 





55，MVC的各个部分都有那些技术来实现?如何实现?

        MVC是Model－View－Controller的简写。Model代表的是应用的业务逻辑（通过JavaBean，EJB组件实现），View是应用的表示面（由JSP页面产生），Controller是提供应用的处理过程控制（一般是一个Servlet），通过这种设计模型把应用逻辑，处理过程和显示逻辑分成不同的组件实现。这些组件可以进行交互和重用。




 56，jsp有哪些内置对象?作用分别是什么?


        JSP共有以下9个内置的对象：

        1，request 用户端请求，此请求会包含来自GET/POST请求的参数

        2，response 网页传回用户端的回应

        3，pageContext 网页的属性是在这里管理

        4，session 与请求有关的会话期

        5，application servlet 正在执行的内容

        6，out 用来传送回应的输出

        7，config  servlet的构架部件

        8，page JSP网页本身

        9，exception 针对错误网页，未捕捉的例外




57，Http中，get和post方法的区别

        1，Get是向服务器发索取数据的一种请求，而Post是向服务器提交数据的一种请求

        2，Get是获取信息，而不是修改信息，类似数据库查询功能一样，数据不会被修改

        3，Get请求的参数会跟在url后进行传递，请求的数据会附在URL之后，以?分割URL和传输数据，参数之间以&相连,％XX中的XX为该符号以16进制表示的ASCII，如果数据是英文字母/数字，原样发送，如果是空格，转换为+，如果是中文/其他字符，则直接把字符串用BASE64加密。
        4，Get传输的数据有大小限制，因为GET是通过URL提交数据，那么GET可提交的数据量就跟URL的长度有直接关系了，不同的浏览器对URL的长度的限制是不同的。

        5，GET请求的数据会被浏览器缓存起来，用户名和密码将明文出现在URL上，其他人可以查到历史浏览记录，数据不太安全。

在服务器端，用Request.QueryString来获取Get方式提交来的数据
Post请求则作为http消息的实际内容发送给web服务器，数据放置在HTML Header内提交，Post没有限制提交的数据。Post比Get安全，当数据是中文或者不敏感的数据，则用get，因为使用get，参数会显示在地址，对于敏感数据和不是中文字符的数据，则用post。
        6，POST表示可能修改变服务器上的资源的请求，在服务器端，用Post方式提交的数据只能用Request.Form来获取。

（仅供参考，如果有更好的回答，欢迎探讨）




58，什么是cookie？Session和cookie有什么区别？

    Cookie是会话技术,将用户的信息保存到浏览器的对象.

    区别：

        (1)cookie数据存放在客户的浏览器上，session数据放在服务器上
        (2)cookie不是很安全，别人可以分析存放在本地的COOKIE并进行COOKIE欺骗,如果主要考虑到安全应当使用session
         (3)session会在一定时间内保存在服务器上。当访问增多，会比较占用你服务器的性能，如果主要考虑到减轻服务器性能方面，应当使用COOKIE
         (4)单个cookie在客户端的限制是3K，就是说一个站点在客户端存放的COOKIE不能3K。

    结论：

        将登陆信息等重要信息存放为SESSION;其他信息如果需要保留，可以放在COOKIE中。




59，jsp和servlet的区别、共同点、各自应用的范围？

        JSP是Servlet技术的扩展，本质上就是Servlet的简易方式。JSP编译后是“类servlet”。

        Servlet和JSP最主要的不同点在于：Servlet的应用逻辑是在Java文件中，并且完全从表示层中的HTML里分离开来。而JSP的情况是Java和HTML可以组合成一个扩展名为.jsp的文件。

        JSP侧重于视图，Servlet主要用于控制逻辑。在struts框架中,JSP位于MVC设计模式的视图层,而Servlet位于控制层.




60，tomcat容器是如何创建servlet类实例？用到了什么原理？
        当容器启动时，会读取在webapps目录下所有的web应用中的web.xml文件，然后对xml文件进行解析，并读取servlet注册信息。然后，将每个应用中注册的servlet类都进行加载，并通过反射的方式实例化。（有时候也是在第一次请求时实例化）
        在servlet注册时加上<load-on-startup>1</load-on-startup>如果为正数，则在一开始就实例化，如果不写或为负数，则第一次请求实例化。

赢在面试之JavaWeb篇（7）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/ISyekYA5AgEJHbcugYDyTw 

61，JDBC访问数据库的基本步骤是什么？
1，加载驱动
2，通过DriverManager对象获取连接对象Connection
 3，通过连接对象获取会话
4，通过会话进行数据的增删改查，封装对象
5，关闭资源




62，说说preparedStatement和Statement的区别
1，效率：预编译会话比普通会话对象，数据库系统不会对相同的sql语句不会再次编译
2，安全性：可以有效的避免sql注入攻击！sql注入攻击就是从客户端输入一些非法的特殊字符，而使服务器端在构造sql语句的时候仍然能够正确构造，从而收集程序和服务器的信息和数据。
 比如：“select * from t_user where userName = ‘” + userName + “ ’ and password =’” + password + “’”
如果用户名和密码输入的是’1’ or ‘1’=’1’ ;  则生产的sql语句是：
“select * from t_user where userName = ‘1’ or ‘1’ =’1’  and password =’1’  or ‘1’=’1’  这个语句中的where 部分没有起到对数据筛选的作用。




63，说说事务的概念，在JDBC编程中处理事务的步骤。
1 事务是作为单个逻辑工作单元执行的一系列操作。
2，一个逻辑工作单元必须有四个属性，称为原子性、一致性、隔离性和持久性 (ACID) 属性，只有这样才能成为一个事务
 事务处理步骤：
3，conn.setAutoComit(false);设置提交方式为手工提交
4，conn.commit()提交事务
5，出现异常，回滚 conn.rollback();




64，数据库连接池的原理。为什么要使用连接池。
1，数据库连接是一件费时的操作，连接池可以使多个操作共享一个连接。
2，数据库连接池的基本思想就是为数据库连接建立一个“缓冲池”。预先在缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去。我们可以通过设定连接池最大连接数来防止系统无尽的与数据库连接。更为重要的是我们可以通过连接池的管理机制监视数据库的连接的数量、使用情况，为系统开发，测试及性能调整提供依据。
3，使用连接池是为了提高对数据库连接资源的管理




65，JDBC的脏读是什么？哪种数据库隔离级别能防止脏读？

　　当我们使用事务时，有可能会出现这样的情况，有一行数据刚更新，与此同时另一个查询读到了这个刚更新的值。这样就导致了脏读，因为更新的数据还没有进行持久化，更新这行数据的业务可能会进行回滚，这样这个数据就是无效的。数据库的TRANSACTIONREADCOMMITTED，TRANSACTIONREPEATABLEREAD，和TRANSACTION_SERIALIZABLE隔离级别可以防止脏读。




66，什么是幻读，哪种隔离级别可以防止幻读？

　　幻读是指一个事务多次执行一条查询返回的却是不同的值。假设一个事务正根据某个条件进行数据查询，然后另一个事务插入了一行满足这个查询条件的数据。之后这个事务再次执行了这条查询，返回的结果集中会包含刚插入的那条新数据。这行新数据被称为幻行，而这种现象就叫做幻读。

　　只有TRANSACTION_SERIALIZABLE隔离级别才能防止产生幻读。




67，JDBC的DriverManager是用来做什么的？ 
JDBC的DriverManager是一个工厂类，我们通过它来创建数据库连接。当JDBC的Driver类被加载进来时，它会自己注册到DriverManager类里面
 然后我们会把数据库配置信息传成DriverManager.getConnection()方法，DriverManager会使用注册到它里面的驱动来获取数据库连接，并返回给调用的程序。 





68，execute，executeQuery，executeUpdate的区别是什么？ 
         1，Statement的execute(String query)方法用来执行任意的SQL查询，如果查询的结果是一个ResultSet，这个方法就返回true。如果结果不是ResultSet，比如insert或者update查询，它就会返回false。我们可以通过它的getResultSet方法来获取ResultSet，或者通过getUpdateCount()方法来获取更新的记录条数。 
         2，Statement的executeQuery(String query)接口用来执行select查询，并且返回ResultSet。即使查询不到记录返回的ResultSet也不会为null。我们通常使用executeQuery来执行查询语句，这样的话如果传进来的是insert或者update语句的话，它会抛出错误信息为 “executeQuery method can not be used for update”的java.util.SQLException。 ,
         3，Statement的executeUpdate(String query)方法用来执行insert或者update/delete（DML）语句，或者 什么也不返回，对于DDL语句，返回值是int类型，如果是DML语句的话，它就是更新的条数，如果是DDL的话，就返回0。 
只有当你不确定是什么语句的时候才应该使用execute()方法，否则应该使用executeQuery或者executeUpdate方法。




69，SQL查询出来的结果分页展示一般怎么做？

Oracle：


select * from 
 (select *,rownum as tempid from student )  t 
 where t.tempid between ” + pageSize*(pageNumber-1) + ” and ” + pageSize*pageNumber

MySQL：
   select * from students limit ” + pageSize*(pageNumber-1) + “,” + pageSize;

sql server: 
    select top ” + pageSize + ” * from students where id not in + 
 (select top ” + pageSize * (pageNumber-1) +  id from students order by id) +  
“order by id;




70，JDBC的ResultSet是什么？ 
在查询数据库后会返回一个ResultSet，它就像是查询结果集的一张数据表。  
ResultSet对象维护了一个游标，指向当前的数据行。开始的时候这个游标指向的是第一行。如果调用了ResultSet的next()方法游标会下移一行，如果没有更多的数据了，next()方法会返回false。可以在for循环中用它来遍历数据集。  
默认的ResultSet是不能更新的，游标也只能往下移。也就是说你只能从第一行到最后一行遍历一遍。不过也可以创建可以回滚或者可更新的ResultSet 


当生成ResultSet的Statement对象要关闭或者重新执行或是获取下一个ResultSet的时候，ResultSet对象也会自动关闭。 
可以通过ResultSet的getter方法，传入列名或者从1开始的序号来获取列数据。 

在面试之Java框架篇（8）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/974G5gmBp4uf11z4gDEDhw 

71，谈谈你对Struts的理解。

        1. struts是一个按MVC模式设计的Web层框架，其实它就是一个Servlet，这个Servlet名为ActionServlet，或是ActionServlet的子类。我们可以在web.xml文件中将符合某种特征的所有请求交给这个Servlet处理，这个Servlet再参照一个配置文件将各个请求分别分配给不同的action去处理。

(struts的配置文件可以有多个，可以按模块配置各自的配置文件，这样可以防止配置文件的过度膨胀)

        2.ActionServlet把请求交给action去处理之前，会将请求参数封装成一个formbean对象（就是一个java类，这个类中的每个属性对应一个请求参数），

        3.要说明的是， ActionServlet把formbean对象传递给action的execute方法之前，可能会调用formbean的validate方法进行校验，只有校验通过后才将这个formbean对象传递给action的execute方法，否则，它将返回一个错误页面，这个错误页面由input属性指定。

        4.action执行完后要返回显示的结果视图，这个结果视图是用一个ActionForward对象来表示的，actionForward对象通过struts-config.xml配置文件中的配置关联到某个jsp页面，因为程序中使用的是在struts-config.xml配置文件为jsp页面设置的逻辑名，这样可以实现action程序代码与返回的jsp页面名称的解耦。

 （以上，也可以结合自己使用感受谈自己的看法）




72、谈谈你对Hibernate的理解。

        1. 面向对象设计的软件内部运行过程可以理解成就是在不断创建各种新对象、建立对象之间的关系，调用对象的方法来改变各个对象的状态和对象消亡的过程，不管程序运行的过程和操作怎么样，本质上都是要得到一个结果，程序上一个时刻和下一个时刻的运行结果的差异就表现在内存中的对象状态发生了变化。

        2.为了在关机和内存空间不够的状况下，保持程序的运行状态，需要将内存中的对象状态保存到持久化设备和从持久化设备中恢复出对象的状态，通常都是保存到关系数据库来保存大量对象信息。从Java程序的运行功能上来讲，保存对象状态的功能相比系统运行的其他功能来说，应该是一个很不起眼的附属功能，java采用jdbc来实现这个功能，这个不起眼的功能却要编写大量的代码，而做的事情仅仅是保存对象和恢复对象，并且那些大量的jdbc代码并没有什么技术含量，基本上是采用一套例行公事的标准代码模板来编写，是一种苦活和重复性的工作。

        3.通过数据库保存java程序运行时产生的对象和恢复对象，其实就是实现了java对象与关系数据库记录的映射关系，称为ORM（即Object RelationMapping），人们可以通过封装JDBC代码来实现了这种功能，封装出来的产品称之为ORM框架，Hibernate就是其中的一种流行ORM框架。使用Hibernate框架，不用写JDBC代码，仅仅是调用一个save方法，就可以将对象保存到关系数据库中，仅仅是调用一个get方法，就可以从数据库中加载出一个对象。

        4.使用Hibernate的基本流程是：配置Configuration对象、产生SessionFactory、创建session对象，启动事务，完成CRUD操作，提交事务，关闭session。

        5.使用Hibernate时，先要配置hibernate.cfg.xml文件，其中配置数据库连接信息和方言等，还要为每个实体配置相应的hbm.xml文件，hibernate.cfg.xml文件中需要登记每个hbm.xml文件。

        6.在应用Hibernate时，重点要了解Session的缓存原理，级联，延迟加载和hql查询。

（以上，也可以结合自己使用JDBC时的繁琐谈hibernate的感受）




73，谈谈你对Spring的理解。

        1.Spring是实现了工厂模式的工厂类（在这里有必要解释清楚什么是工厂模式），这个类名为BeanFactory（实际上是一个接口），在程序中通常BeanFactory的子类ApplicationContext。Spring相当于一个大的工厂类，在其配置文件中通过<bean>元素配置用于创建实例对象的类名和实例对象的属性。

        2. Spring提供了对IOC良好支持，IOC是一种编程思想，是一种架构艺术，利用这种思想可以很好地实现模块之间的解耦，IOC也称为DI（Depency Injection）。

        3. Spring提供了对AOP技术的良好封装， AOP称为面向切面编程，就是系统中有很多各不相干的类的方法，在这些众多方法中要加入某种系统功能的代码，例如，加入日志，加入权限判断，加入异常处理，这种应用称为AOP。

        实现AOP功能采用的是代理技术，客户端程序不再调用目标，而调用代理类，代理类与目标类对外具有相同的方法声明，有两种方式可以实现相同的方法声明，一是实现相同的接口，二是作为目标的子类。

        在JDK中采用Proxy类产生动态代理的方式为某个接口生成实现类，如果要为某个类生成子类，则可以用CGLI B。在生成的代理类的方法中加入系统功能和调用目标类的相应方法，系统功能的代理以Advice对象进行提供，显然要创建出代理对象，至少需要目标类和Advice类。spring提供了这种支持，只需要在spring配置文件中配置这两个元素即可实现代理和aop功能。

（以上，也可以结合自己使用感受谈自己的看法）





74，谈谈Struts的优缺点
优点：
1. 实现MVC模式，结构清晰,使开发者只关注业务逻辑的实现.

2．有丰富的tag可以用 ,Struts的标记库(Taglib)，如能灵活动用，则能大大提高开发效率

3. 页面导航使系统的脉络更加清晰。通过一个配置文件，即可把握整个系统各部分之间的联系，这对于后期的维护有着莫大的好处。尤其是当另一批开发者接手这个项目时，这种优势体现得更加明显。

4. 提供Exception处理机制 .

5. 数据库链接池管理

6. 支持I18N

缺点：

一，转到展示层时，需要配置forward，如果有十个展示层的jsp，需要配置十次struts，而且还不包括有时候目录、文件变更，需要重新修改forward，注意，每次修改配置之后，要求重新部署整个项目，而tomcate这样的服务器，还必须重新启动服务器

二，Struts的Action必需是thread－safe方式，它仅仅允许一个实例去处理所有的请求。所以action用到的所有的资源都必需统一同步，这个就引起了线程安全的问题。

三，测试不方便. Struts的每个Action都同Web层耦合在一起，这样它的测试依赖于Web容器，单元测试也很难实现。不过有一个Junit的扩展工具Struts TestCase可以实现它的单元测试。

四，类型的转换. Struts的FormBean把所有的数据都作为String类型，它可以使用工具Commons-Beanutils进行类型转化。但它的转化都是在Class级别，而且转化的类型是不可配置的。类型转化时的错误信息返回给用户也是非常困难的。

五，对Servlet的依赖性过强. Struts处理Action时必需要依赖ServletRequest和ServletResponse，所有它摆脱不了Servlet容器。

六，前端表达式语言方面.Struts集成了JSTL，所以它主要使用JSTL的表达式语言来获取数据。可是JSTL的表达式语言在Collection和索引属性方面处理显得很弱。

七，对Action执行的控制困难. Struts创建一个Action，如果想控制它的执行顺序将会非常困难。甚至你要重新去写Servlet来实现你的这个功能需求。

八，对Action执行前和后的处理. Struts处理Action的时候是基于class的hierarchies，很难在action处理前和后进行操作。

九，对事件支持不够.在struts中，实际是一个表单Form对应一个Action类(或DispatchAction)，换一句话说：在Struts中实际是一个表单只能对应一个事件，struts这种事件方式称为application event，application event和component event相比是一种粗粒度的事件




75，iBatis与Hibernate有什么不同?

        相同点：屏蔽jdbc api的底层访问细节，使用我们不用与jdbc api打交道，就可以访问数据。

        jdbc api编程流程固定，还将sql语句与java代码混杂在了一起，经常需要拼凑sql语句，细节很繁琐。

        ibatis的好处：屏蔽jdbc api的底层访问细节；将sql语句与java代码进行分离;提供了将结果集自动封装称为实体对象和对象的集合的功能，queryForList返回对象集合，用queryForObject返回单个对象；提供了自动将实体对象的属性传递给sql语句的参数。

        Hibernate是一个全自动的orm映射工具，它可以自动生成sql语句,ibatis需要我们自己在xml配置文件中写sql语句，hibernate要比ibatis功能负责和强大很多。因为hibernate自动生成sql语句，我们无法控制该语句，我们就无法去写特定的高效率的sql。对于一些不太复杂的sql查询，hibernate可以很好帮我们完成，但是，对于特别复杂的查询，hibernate就很难适应了，这时候用ibatis就是不错的选择，因为ibatis还是由我们自己写sql语句。

76，在hibernate进行多表查询每个表中各取几个字段，也就是说查询出来的结果集没有一个实体类与之对应如何解决？

解决方案一,：按照Object[]数据取出数据，然后自己组bean

解决方案二：对每个表的bean写构造函数，比如表一要查出field1,field2两个字段，那么有一个构造函数就是Bean(type1filed1,type2

field2) ，然后在hql里面就可以直接生成这个bean了。




77，介绍一下Hibernate的二级缓存

        按照以下思路来回答：

        （1）首先说清楚什么是缓存

        （2）再说有了hibernate的Session就是一级缓存，即有了一级缓存，为什么还要有二级缓存

        （3）最后再说如何配置Hibernate的二级缓存。

    1，缓存就是把以前从数据库中查询出来和使用过的对象保存在内存中（一个数据结构中），这个数据结构通常是或类似HashMap，当以后要使用某个对象时，先查询缓存中是否有这个对象，如果有则使用缓存中的对象，如果没有则去查询数据库，并将查询出来的对象保存在缓存中，以便下次使用。

    2，Hibernate的Session就是一种缓存，我们通常将之称为Hibernate的一级缓存，当想使用session从数据库中查询出一个对象时，Session也是先从自己内部查看是否存在这个对象，存在则直接返回，不存在才去访问数据库，并将查询的结果保存在自己内部。

        由于Session代表一次会话过程，一个Session与一个数据库连接相关连，所以Session最好不要长时间保持打开，通常仅用于一个事务当中，在事务结束时就应关闭。并且Session是线程不安全的，被多个线程共享时容易出现问题。通常只有那种全局意义上的缓存才是真正的缓存应用，才有较大的缓存价值，因此，Hibernate的Session这一级缓存的缓存作用并不明显，应用价值不大。Hibernate的二级缓存就是要为Hibernate配置一种全局缓存，让多个线程和多个事务都可以共享这个缓存。我们希望的是一个人使用过，其他人也可以使用，session没有这种效果。

    3，二级缓存是独立于Hibernate的软件部件，属于第三方的产品，多个厂商和组织都提供有缓存产品，例如，EHCache和OSCache等等。在Hibernate中使用二级缓存，首先就要在hibernate.cfg.xml配置文件中配置使用哪个厂家的缓存产品，接着需要配置该缓存产品自己的配置文件，最后要配置Hibernate中的哪些实体对象要纳入到二级缓存的管理中。明白了二级缓存原理和有了这个思路后，很容易配置起Hibernate的二级缓存。

        扩展知识：一个SessionFactory可以关联一个二级缓存，也即一个二级缓存只能负责缓存一个数据库中的数据，当使用Hibernate的二级缓存后，注意不要有其他的应用或SessionFactory来更改当前数据库中的数据，这样缓存的数据就会与数据库中的实际数据不一致。




78，JDO是什么?

        JDO是Java对象持久化的新的规范，为java data object的简称,也是一个用于存取某种数据仓库中的对象的标准化API。JDO提供了透明的对象存储，因此对开发人员来说，存储数据对象完全不需要额外的代码（如JDBC API的使用）。这些繁琐的例行工作已经转移到JDO产品提供商身上，使开发人员解脱出来，从而集中时间和精力在业务逻辑上。另外，JDO很灵活，因为它可以在任何数据底层上运行。


        比较：JDBC只是面向关系数据库（RDBMS）JDO更通用，提供到任何数据底层的存储功能，比如关系数据库、文件、XML以及对象数据库（ODBMS）等等，使得应用可移植性更强。




79，Hibernate的一对多和多对一双向关联的区别？？

        一对多关联映射和多对一关联映射实现的基本原理都是一样的，既是在多的一端加入一个外键指向一的一端外键，而主要的区别就是维护端不同。
        它们的区别在于维护的关系不同：
 一对多关联映射是指在加载一的一端数据的同时加载多的一端的数据多对一关联映射是指在加载多的一端数据的同时加载一的一端的数据。


80，Hibernate是如何延迟加载? 

       1. Hibernate2延迟加载实现：a)实体对象 b)集合（Collection） 

        2. Hibernate3 提供了属性的延迟加载功能 当Hibernate在查询数据的时候，数据并没有存在与内存中，当程序真正对数据的操作时，对象才存在与内存中，就实现了延迟加载，他节省了服务器的内存开销，从而提高了服务器的性能。  

 
赢在面试之Java框架篇（9）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/R3W1uAfC9HOM68b75gOPtw 

  spring现在无疑是Java中最火的框架，使用范围广，几乎每个公司面试都会涉及spring和数据库，你可以对Struts不熟悉，但一定不能表现出对spring不了解。第九篇赢在面试全篇介绍spring常考点。数据库重中之重会在后面花五篇介绍常问题型




81，使用Spring框架的好处是什么？

        轻量：Spring 是轻量的，基本的版本大约2MB。

        控制反转：Spring通过控制反转实现了松散耦合，对象们给出它们的依赖，而不是创建或查找依赖的对象们。

        面向切面的编程(AOP)：Spring支持面向切面的编程，并且把应用业务逻辑和系统服务分开。

        容器：Spring 包含并管理应用中对象的生命周期和配置。

        MVC框架：Spring的WEB框架是个精心设计的框架，是Web框架的一个很好的替代品。

        事务管理：Spring 提供一个持续的事务管理接口，可以扩展到上至本地事务下至全局事务（JTA）。

        异常处理：Spring 提供方便的API把具体技术相关的异常（比如由JDBC，Hibernate or JDO抛出的）转化为一致的unchecked 异常。




82. ApplicationContext通常的实现是什么?

        FileSystemXmlApplicationContext ：此容器从一个XML文件中加载beans的定义，XML Bean 配置文件的全路径名必须提供给它的构造函数。

        ClassPathXmlApplicationContext：此容器也从一个XML文件中加载beans的定义，这里，你需要正确设置classpath因为这个容器将在classpath里找bean配置。

        WebXmlApplicationContext：此容器加载一个XML文件，此文件定义了一个WEB应用的所有bean。




83，什么是Spring的依赖注入？有哪些方法进行依赖注入

        依赖注入，是IOC的一个方面，是个通常的概念，它有多种解释。这概念是说你不用创建对象，而只需要描述它如何被创建。你不在代码里直接组装你的组件和服务，但是要在配置文件里描述哪些组件需要哪些服务，之后一个容器（IOC容器）负责把他们组装起来。

        构造器依赖注入：构造器依赖注入通过容器触发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖。

        Setter方法注入：Setter方法注入是容器通过调用无参构造器或无参static工厂 方法实例化bean之后，调用该bean的setter方法，即实现了基于setter的依赖注入。




84，什么是Spring beans?

        Spring beans 是那些形成Spring应用的主干的java对象。它们被Spring IOC容器初始化，装配，和管理。这些beans通过容器中配置的元数据创建。比如，以XML文件中<bean/> 的形式定义。

        Spring 框架定义的beans都是单件beans。在bean tag中有个属性”singleton”，如果它被赋为TRUE，bean 就是单件，否则就是一个 prototype bean。默认是TRUE，所以所有在Spring框架中的beans 缺省都是单件。




85，解释Spring支持的几种bean的作用域。

        Spring框架支持以下五种bean的作用域：

        singleton : bean在每个Spring ioc 容器中只有一个实例。

        prototype：一个bean的定义可以有多个实例。

        request：每次http请求都会创建一个bean，该作用域仅在基于web的        Spring ApplicationContext情形下有效。

        session：在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

        global-session：在一个全局的HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

缺省的Spring bean 的作用域是Singleton.




86，解释Spring框架中bean的生命周期。

        1，Spring容器 从XML 文件中读取bean的定义，并实例化bean。

        2，Spring根据bean的定义填充所有的属性。

        3，如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。

        4，如果Bean 实现了 BeanFactoryAware 接口， Spring传递beanfactory 给setBeanFactory 方法。

        5，如果有任何与bean相关联的BeanPostProcessors，Spring会在postProcesserBeforeInitialization()方法内调用它们。

        6，如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。

        7，如果有BeanPostProcessors 和bean 关联，这些bean的postProcessAfterInitialization() 方法将被调用。

       8，如果bean实现了 DisposableBean，它将调用destroy()方法。




87，在 Spring中如何注入一个java集合？

Spring提供以下几种集合的配置元素：

    <list>类型用于注入一列值，允许有相同的值。

    <set> 类型用于注入一组值，不允许有相同的值。

    <map> 类型用于注入一组键值对，键和值都可以为任意类型。

    <props>类型用于注入一组键值对，键和值都只能为String类型。




88，解释不同方式的自动装配 。

有五种自动装配的方式，用来指导Spring容器用自动装配方式进行依赖注入。

        no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。

        byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。

        byType:：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。

        constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。

        autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。




89，Spring框架的事务管理有哪些优点？

        它为不同的事务API  如 JTA，JDBC，Hibernate，JPA 和JDO，提供一个不变的编程模式。

        它为编程式事务管理提供了一套简单的API而不是一些复杂的事务API如

        它支持声明式事务管理。

        它和Spring各种数据访问抽象层很好得集成。




90.什么是基于Java的Spring注解配置? 给一些注解的例子.

        基于Java的配置，允许你在少量的Java注解的帮助下，进行你的大部分Spring配置而非通过XML文件。

        以@Configuration 注解为例，它用来标记类可以当做一个bean的定义，被Spring IOC容器使用。另一个例子是@Bean注解，它表示此方法将要返回一个对象，作为一个bean注册进Spring应用上下文。

赢在面试之Java持久层（10）   
 
编辑词条   









   
    
目录  



98，JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？ 


99，MyBatis与Hibernate有哪些不同？


100，简单的说一下MyBatis的一级缓存和二级缓存？ 

















  
 [显示全部] 

   
 
转载：https://mp.weixin.qq.com/s/AMrxQZOwmtb-6F63aX-4rA

91，什么是ORM？ 
         对象关系映射（Object-Relational Mapping，简称ORM）是一种为了解决程序的面向对象模型与数据库的关系模型互不匹配问题的技术；

        简单的说，ORM是通过使用描述对象和数据库之间映射的元数据（在Java中可以用XML或者是注解），将程序中的对象自动持久化到关系数据库中或者将关系数据库表中的行转换成Java对象，其本质上就是将数据从一种形式转换到另外一种形式。




92，Hibernate中SessionFactory是线程安全的吗？Session是线程安全的吗（两个线程能够共享同一个Session吗）？ 
         SessionFactory对应Hibernate的一个数据存储的概念，它是线程安全的，可以被多个线程并发访问。SessionFactory一般只会在启动的时候构建。对于应用程序，最好将SessionFactory通过单例模式进行封装以便于访问。

        Session是一个轻量级非线程安全的对象（线程间不能共享session），它表示与数据库进行交互的一个工作单元。Session是由SessionFactory创建的，在任务完成之后它会被关闭。Session是持久层服务对外提供的主要接口。

        Session会延迟获取数据库连接（也就是在需要的时候才会获取）。为了避免创建太多的session，可以使用ThreadLocal将session和当前线程绑定在一起，这样可以让同一个线程获得的总是同一个session。Hibernate 3中SessionFactory的getCurrentSession()方法就可以做到。




93，Session的save()、update()、merge()、lock()、saveOrUpdate()和persist()方法分别是做什么的？有什么区别？ 
         Hibernate的对象有三种状态：瞬时态（transient）、持久态（persistent）和游离态（detached）。

        瞬时态的实例可以通过调用save()、persist()或者saveOrUpdate()方法变成持久态；

        游离态的实例可以通过调用 update()、saveOrUpdate()、lock()或者replicate()变成持久态。save()和persist()将会引发SQL的INSERT语句，而update()或merge()会引发UPDATE语句。

        save()和update()的区别在于一个是将瞬时态对象变成持久态，一个是将游离态对象变为持久态。merge()方法可以完成save()和update()方法的功能，它的意图是将新的状态合并到已有的持久化对象上或创建新的持久化对象。

        对于persist()方法，按照官方文档的说明：

        1、persist()方法把一个瞬时态的实例持久化，但是并不保证标识符被立刻填入到持久化实例中，标识符的填入可能被推迟到flush的时间；

        2、persist()方法保证当它在一个事务外部被调用的时候并不触发一个INSERT语句，当需要封装一个长会话流程的时候，persist()方法是很有必要的；

        3、save()方法不保证第2条，它要返回标识符，所以它会立即执行INSERT语句，不管是在事务内部还是外部。至于lock()方法和update()方法的区别，update()方法是把一个已经更改过的脱管状态的对象变成持久状态；lock()方法是把一个没有更改过的脱管状态的对象变成持久状态。




94，阐述Session加载实体对象的过程。 
         1、Session在调用数据库查询功能之前，首先会在一级缓存中通过实体类型和主键进行查找，如果一级缓存查找命中且数据状态合法，则直接返回； 
         2、如果一级缓存没有命中，接下来Session会在当前NonExists记录（相当于一个查询**，如果出现重复的无效查询可以迅速做出判断，从而提升性能）中进行查找，如果NonExists中存在同样的查询条件，则返回null； 
         3、如果一级缓存查询失败查询二级缓存，如果二级缓存命中直接返回； 
         4、如果之前的查询都未命中，则发出SQL语句，如果查询未发现对应记录则将此次查询添加到Session的NonExists中加以记录，并返回null； 
         5、根据映射配置和SQL语句得到ResultSet，并创建对应的实体对象； 
         6、将对象纳入Session（一级缓存）的管理； 
         7、如果有对应的拦截器，则执行拦截器的onLoad方法； 
         8、如果开启并设置了要使用二级缓存，则将数据对象纳入二级缓存； 
         9、返回数据对象。




95，MyBatis中使用#和$书写占位符有什么区别？ 
         #将传入的数据都当成一个字符串，会对传入的数据自动加上引号；

    $将传入的数据直接显示生成在SQL中。

        注意：使用$占位符可能会导致SQL注射攻击，能用#的地方就不要使用$，写order by子句的时候应该用$而不是#。




96，解释一下MyBatis中命名空间（namespace）的作用。 
         在大型项目中，可能存在大量的SQL语句，这时候为每个SQL语句起一个唯一的标识（ID）就变得并不容易了。为了解决这个问题，在MyBatis中，可以为每个映射文件起一个唯一的命名空间，这样定义在这个映射文件中的每个SQL语句就成了定义在这个命名空间中的一个ID。只要我们能够保证每个命名空间中这个ID是唯一的，即使在不同映射文件中的语句ID相同，也不会再产生冲突了。




97、MyBatis中的动态SQL是什么意思？ 
         对于一些复杂的查询，我们可能会指定多个查询条件，但是这些条件可能存在也可能不存在，如果不使用持久层框架我们可能需要自己拼装SQL语句，不过MyBatis提供了动态SQL的功能来解决这个问题。MyBatis中用于实现动态SQL的元素主要有： 
- if    - choose / when / otherwise    - trim    - where    - set     - foreach

用法举例：

   <select id="foo" parameterType="Blog" resultType="Blog">        
   select * from t_blog where 1 = 1         <if test="title != null">            
           and title = #{title}         </if>
        <if test="content != null">            
           and content = #{content}         </if>
        <if test="owner != null">            
           and owner = #{owner}         </if>
   </select>
 98，JDBC编程有哪些不足之处，MyBatis是如何解决这些问题的？    

        1、JDBC：数据库链接创建、释放频繁造成系统资源浪费从而影响系统性能，如果使用数据库链接池可解决此问题。

        MyBatis：在SqlMapConfig.xml中配置数据链接池，使用连接池管理数据库链接。

        2、JDBC：Sql语句写在代码中造成代码不易维护，实际应用sql变化的可能较大，sql变动需要改变java代码。

        MyBatis：将Sql语句配置在XXXXmapper.xml文件中与java代码分离。
        3、JDBC：向sql语句传参数麻烦，因为sql语句的where条件不一定，可能多也可能少，占位符需要和参数一一对应。

        MyBatis： Mybatis自动将java对象映射至sql语句。
        4，JDBC：对结果集解析麻烦，sql变化导致解析代码变化，且解析前需要遍历，如果能将数据库记录封装成pojo对象解析比较方便。

        MyBatis：Mybatis自动将sql执行结果映射至java对象。




99，MyBatis与Hibernate有哪些不同？   

        1、Mybatis和hibernate不同，它不完全是一个ORM框架，因为MyBatis需要程序员自己编写Sql语句，不过mybatis可以通过XML或注解方式灵活配置要运行的sql语句，并将java对象和sql语句映射生成最终执行的sql，最后将sql执行的结果再映射生成java对象。           
         2、Mybatis学习门槛低，简单易学，程序员直接编写原生态sql，可严格控制sql执行性能，灵活度高，非常适合对关系数据模型要求不高的软件开发，例如互联网软件、企业运营类软件等，因为这类软件需求变化频繁，一但需求变化要求成果输出迅速。但是灵活的前提是mybatis无法做到数据库无关性，如果需要实现支持多种数据库的软件则需要自定义多套sql映射文件，工作量大。                
	 3、Hibernate对象/关系映射能力强，数据库无关性好，对于关系模型要求高的软件（例如需求固定的定制化软件）如果用hibernate开发可以节省很多代码，提高效率。但是Hibernate的缺点是学习门槛高，要精通门槛更高，而且怎么设计O/R映射，在性能和对象模型之间如何权衡，以及怎样用好Hibernate需要具有很强的经验和能力才行。           
         总之，按照用户的需求在有限的资源环境下只要能做出维护性、扩展性良好的软件架构都是好架构，所以框架只有适合才是最好。

（这里也可以结合自己的理解说，别说的收不住）

 100，简单的说一下MyBatis的一级缓存和二级缓存？    

        Mybatis首先去缓存中查询结果集，如果没有则查询数据库，如果有则从缓存取出返回结果集就不走数据库。Mybatis内部存储缓存使用一个HashMap，key为hashCode+sqlId+Sql语句。value为从查询出来映射生成的java对象
        Mybatis的二级缓存即查询缓存，它的作用域是一个mapper的namespace，即在同一个namespace中查询sql可以从缓存中获取数据。二级缓存是可以跨SqlSession的。
	

赢在面试之数据库篇（11）   
 

 作为一枚Java后端开发者，数据库知识必不可少，对数据库的掌握熟悉度的考察也是对这个人是否有扎实基本功的考察。特别对于初级开发者，面试可能不会去问框架相关知识，但是绝对不会不去考察数据库知识，这里收集一些常见类型的SQL语句，无论对于平常开发还是准备面试，都会有助益。

基本表结构：

        student(sno,sname,sage,ssex)学生表
        course(cno,cname,tno) 课程表
        sc(sno,cno,score) 成绩表


        teacher(tno,tname) 教师表




101，查询课程1的成绩比课程2的成绩高的所有学生的学号
select a.sno from
 (select sno,score from sc where cno=1) a,
 (select sno,score from sc where cno=2) b
 where a.score>b.score and a.sno=b.sno




102，查询平均成绩大于60分的同学的学号和平均成绩
select a.sno as "学号", avg(a.score) as "平均成绩" 
from
 (select sno,score from sc) a 
 group by sno having avg(a.score)>60





103，查询所有同学的学号、姓名、选课数、总成绩
select a.sno as 学号, b.sname as 姓名,
count(a.cno) as 选课数, sum(a.score) as 总成绩
from sc a, student b
 where a.sno = b.sno
 group by a.sno, b.sname


或者：

selectstudent.sno as 学号, student.sname as 姓名,
  count(sc.cno) as 选课数, sum(score) as 总成绩
from student left Outer join sc on student.sno = sc.sno
 group by student.sno, sname

104，查询姓“张”的老师的个数

selectcount(distinct(tname)) from teacher where tname like '张%‘
或者：
select tname as "姓名", count(distinct(tname)) as "人数" 
from teacher 
 where tname like'张%'
group by tname




105，查询没学过“张三”老师课的同学的学号、姓名
select student.sno,student.sname from student
 where sno not in (select distinct(sc.sno) from sc,course,teacher
 where sc.cno=course.cno and teacher.tno=course.tno and teacher.tname='张三')





106，查询同时学过课程1和课程2的同学的学号、姓名
select sno, sname from student
 where sno in (select sno from sc where sc.cno = 1)
 and sno in (select sno from sc where sc.cno = 2)
或者：

selectc.sno, c.sname from
 (select sno from sc where sc.cno = 1) a,
 (select sno from sc where sc.cno = 2) b,
 student c
 where a.sno = b.sno and a.sno = c.sno
或者：

select student.sno,student.sname from student,sc where student.sno=sc.sno and sc.cno=1
 and exists( select * from sc as sc_2 where sc_2.sno=sc.sno and sc_2.cno=2)




107，查询学过“李四”老师所教所有课程的所有同学的学号、姓名
select a.sno, a.sname from student a, sc b
 where a.sno = b.sno and b.cno in
 (select c.cno from course c, teacher d where c.tno = d.tno and d.tname = '李四')

或者：

select a.sno, a.sname from student a, sc b,
 (select c.cno from course c, teacher d where c.tno = d.tno and d.tname = '李四') e
 where a.sno = b.sno and b.cno = e.cno




108，查询课程编号1的成绩比课程编号2的成绩高的所有同学的学号、姓名
select a.sno, a.sname from student a,
 (select sno, score from sc where cno = 1) b,
 (select sno, score from sc where cno = 2) c
 where b.score > c.score and b.sno = c.sno and a.sno = b.sno





109，查询所有课程成绩小于60分的同学的学号、姓名
select sno,sname from student
 where sno not in (select distinct sno from sc where score > 60)





110，查询至少有一门课程与学号为1的同学所学课程相同的同学的学号和姓名
select distinct a.sno, a.sname
 from student a, sc b
 where a.sno <> 1 and a.sno=b.sno and
 b.cno in (select cno from sc where sno = 1)

或者：

select s.sno,s.sname 
 from student s,
 (select sc.sno 
 from sc
 where sc.cno in (select sc1.cno from sc sc1 where sc1.sno=1)and sc.sno<>1
 group by sc.sno)r1
 where r1.sno=s.sno



赢在面试之数据库篇（12）   

在赢在面试之JavaWeb篇（7）中，Oracle分页语句有一些错误，原语句：

select * from
 (select *,rownum as tempid from student )  t
 where t.tempid between ” + pageSize*(pageNumber-1) + ” and ” + pageSize*pageNumber。

修改之后：

select * from
 (select  student.*,rownum as tempid from student )  t
 where t.tempid between ” + pageSize*(pageNumber-1) + ” and ” + pageSize*pageNumber。

        作为一枚Java后端开发者，数据库知识必不可少，对数据库的掌握熟悉度的考察也是对这个人是否有扎实基本功的考察。特别对于初级开发者，面试可能不会去问框架相关知识，但是绝对不会不去考察数据库知识，这里收集一些常见类型的SQL语句，无论对于平常开发还是准备面试，都会有助益。

基本表结构：

        student(sno,sname,sage,ssex)学生表
        course(cno,cname,tno) 课程表
        sc(sno,cno,score) 成绩表


        teacher(tno,tname) 教师表




111、把“sc”表中“王五”所教课的成绩都更改为此课程的平均成绩
update sc set score = (select avg(sc_2.score) from sc sc_2 wheresc_2.cno=sc.cno)
 from course,teacher where course.cno=sc.cno and course.tno=teacher.tno andteacher.tname='王五'


112、查询和编号为2的同学学习的课程完全相同的其他同学学号和姓名
 这一题分两步查：

1，


select sno
 from sc
 where sno <> 2
 group by sno
 having sum(cno) = (select sum(cno) from sc where sno = 2)

2，
select b.sno, b.sname
 from sc a, student b
 where b.sno <> 2 and a.sno = b.sno
 group by b.sno, b.sname
 having sum(cno) = (select sum(cno) from sc where sno = 2)

113、删除学习“王五”老师课的sc表记录
delete sc from course, teacher
 where course.cno = sc.cno and course.tno = teacher.tno and tname = '王五'

114、向sc表中插入一些记录，这些记录要求符合以下条件：
 将没有课程3成绩同学的该成绩补齐, 其成绩取所有学生的课程2的平均成绩
insert sc select sno, 3, (select avg(score) from sc where cno = 2)
 from student
 where sno not in (select sno from sc where cno = 3)

115、按平平均分从高到低显示所有学生的如下统计报表：
-- 学号,企业管理,马克思,UML,数据库,物理,课程数,平均分
select sno as 学号
,max(case when cno = 1 then score end) AS 企业管理
,max(case when cno = 2 then score end) AS 马克思
,max(case when cno = 3 then score end) AS UML
 ,max(case when cno = 4 then score end) AS 数据库
,max(case when cno = 5 then score end) AS 物理
,count(cno) AS 课程数
,avg(score) AS 平均分
FROM sc
 GROUP by sno
 ORDER by avg(score) DESC

116、查询各科成绩最高分和最低分：

以如下形式显示：课程号，最高分，最低分
select cno as 课程号, max(score) as 最高分, min(score) 最低分
from sc group by cno

 select  course.cno as '课程号'
 ,MAX(score) as '最高分'
 ,MIN(score) as '最低分'
from sc,course
 where sc.cno=course.cno
 group by course.cno

117、按各科平均成绩从低到高和及格率的百分数从高到低顺序
SELECT t.cno AS 课程号,
max(course.cname)AS 课程名,
isnull(AVG(score),0) AS 平均成绩,
100 * SUM(CASE WHEN isnull(score,0)>=60 THEN 1 ELSE 0 END)/count(1) AS 及格率
FROM sc t, course
 where t.cno = course.cno
 GROUP BY t.cno
 ORDER BY 及格率 desc

118、查询如下课程平均成绩和及格率的百分数(用"1行"显示): 


企业管理（001），马克思（002），UML （003），数据库（004） 
select 
 avg(case when cno = 1 then score end) as 平均分1,
 avg(case when cno = 2 then score end) as 平均分2,
 avg(case when cno = 3 then score end) as 平均分3,
 avg(case when cno = 4 then score end) as 平均分4,
 100 * sum(case when cno = 1 and score > 60 then 1 else 0 end) / sum(casewhen cno = 1 then 1 else 0 end) as 及格率1,
 100 * sum(case when cno = 2 and score > 60 then 1 else 0 end) / sum(casewhen cno = 2 then 1 else 0 end) as 及格率2,
 100 * sum(case when cno = 3 and score > 60 then 1 else 0 end) / sum(casewhen cno = 3 then 1 else 0 end) as 及格率3,
 100 * sum(case when cno = 4 and score > 60 then 1 else 0 end) / sum(casewhen cno = 4 then 1 else 0 end) as 及格率4
 from sc

119、查询不同老师所教不同课程平均分, 从高到低显示
select max(c.tname) as 教师, max(b.cname) 课程, avg(a.score) 平均分
from sc a, course b, teacher c
 where a.cno = b.cno and b.tno = c.tno
 group by a.cno
 order by 平均分 desc
或者：
select r.tname as '教师',r.rname as '课程' , AVG(score) as '平均分'
from sc,
 (select  t.tname,c.cno as rcso,c.cname as rname
 from teacher t ,course c
 where t.tno=c.tno)r
 where sc.cno=r.rcso
 group by sc.cno,r.tname,r.rname 
 order by AVG(score) desc

120、查询如下课程成绩均在第3名到第6名之间的学生的成绩：
-- [学生ID],[学生姓名],企业管理,马克思,UML,数据库,平均成绩
select top 6 max(a.sno) 学号, max(b.sname) 姓名,
max(case when cno = 1 then score end) as 企业管理,
max(case when cno = 2 then score end) as 马克思,
max(case when cno = 3 then score end) as UML,
 max(case when cno = 4 then score end) as 数据库,
avg(score) as 平均分
from sc a, student b
 where a.sno not in 


(select top 2 sno from sc where cno = 1 order by score desc)
   and a.sno not in (select top 2 sno from sc where cno = 2 order by scoredesc)
   and a.sno not in (select top 2 sno from sc where cno = 3 order by scoredesc)
   and a.sno not in (select top 2 sno from sc where cno = 4 order by scoredesc)
   and a.sno = b.sno
 group by a.sno
     

赢在面试之Java多线程（13）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/4yQbc5e9CR_ifa3YMrdGQA



121，什么是线程？

        线程是操作系统能够进行运算调度的最小单位，它被包含在进程之中，是进程中的实际运作单位。程序员可以通过它进行多处理器编程，你可以使用多线程对运算密集型任务提速。比如，如果一个线程完成一个任务要100毫秒，那么用十个线程完成改任务只需10毫秒。




122，线程和进程有什么区别？

        线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。每个线程都拥有单独的栈内存用来存储本地数据。




123，如何在Java中实现线程？

        两种方式：java.lang.Thread 类的实例就是一个线程但是它需要调用java.lang.Runnable接口来执行，由于线程类本身就是调用的Runnable接口所以你可以继承java.lang.Thread 类或者直接调用Runnable接口来重写run()方法实现线程。




124，Java 关键字volatile 与 synchronized 作用与区别？


    1，volatile
     它所修饰的变量不保留拷贝，直接访问主内存中的。
           在Java内存模型中，有main memory，每个线程也有自己的memory (例如寄存器)。为了性能，一个线程会在自己的memory中保持要访问的变量的副本。这样就会出现同一个变 量在某个瞬间，在一个线程的memory中的值可能与另外一个线程memory中的值，或者main memory中的值不一致的情况。 一个变量声明为volatile，就意味着这个变量是随时会被其他线程修改的，因此不能将它cache在线程memory中。
    2，synchronized


    当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。

         一、当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。

         二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。

         三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。

         四、当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。

         五、以上规则对其它对象锁同样适用.




125，有哪些不同的线程生命周期？

        当我们在Java程序中新建一个线程时，它的状态是New。当我们调用线程的start()方法时，状态被改变为Runnable。线程调度器会为Runnable线程池中的线程分配CPU时间并且讲它们的状态改变为Running。其他的线程状态还有Waiting，Blocked 和Dead。

        

126，你对线程优先级的理解是什么？

        每一个线程都是有优先级的，一般来说，高优先级的线程在运行时会具有优先权，但这依赖于线程调度的实现，这个实现是和操作系统相关的(OS dependent)。我们可以定义线程的优先级，但是这并不能保证高优先级的线程会在低优先级的线程前执行。线程优先级是一个int变量(从1-10)，1代表最低优先级，10代表最高优先级。




127，什么是死锁(Deadlock)？如何分析和避免死锁？

        死锁是指两个以上的线程永远阻塞的情况，这种情况产生至少需要两个以上的线程和两个以上的资源。

        分析死锁，我们需要查看Java应用程序的线程转储。我们需要找出那些状态为BLOCKED的线程和他们等待的资源。每个资源都有一个唯一的id，用这个id我们可以找出哪些线程已经拥有了它的对象锁。

        避免嵌套锁，只在需要的地方使用锁和避免无限期等待是避免死锁的通常办法。




128，什么是线程安全？Vector是一个线程安全类吗？ 


        如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。一个线程安全的计数器类的同一个实例对象在被多个线程使用的情况下也不会出现计算失误。很显然你可以将集合类分成两组，线程安全和非线程安全的。Vector 是用同步方法来实现线程安全的, 而和它相似的ArrayList不是线程安全的。




129，Java中如何停止一个线程？

        Java提供了很丰富的API但没有为停止线程提供API。JDK 1.0本来有一些像stop(), suspend() 和 resume()的控制方法但是由于潜在的死锁威胁因此在后续的JDK版本中他们被弃用了，之后Java API的设计者就没有提供一个兼容且线程安全的方法来停止一个线程。当run() 或者 call() 方法执行完的时候线程会自动结束,如果要手动结束一个线程，你可以用volatile 布尔变量来退出run()方法的循环或者是取消任务来中断线程




130，什么是ThreadLocal?

        ThreadLocal用于创建线程的本地变量，我们知道一个对象的所有线程会共享它的全局变量，所以这些变量不是线程安全的，我们可以使用同步技术。但是当我们不想使用同步的时候，我们可以选择ThreadLocal变量。

        每个线程都会拥有他们自己的Thread变量，它们可以使用get()\set()方法去获取他们的默认值或者在线程内部改变他们的值。ThreadLocal实例通常是希望它们同线程状态关联起来是private static属性。




131，Sleep()、suspend()和wait()之间有什么区别？

        Thread.sleep()使当前线程在指定的时间处于“非运行”（Not Runnable）状态。线程一直持有对象的监视器。比如一个线程当前在一个同步块或同步方法中，其它线程不能进入该块或方法中。如果另一线程调用了interrupt()方法，它将唤醒那个“睡眠的”线程。

        注意：sleep()是一个静态方法。这意味着只对当前线程有效，一个常见的错误是调用t.sleep()，（这里的t是一个不同于当前线程的线程）。即便是执行t.sleep()，也是当前线程进入睡眠，而不是t线程。t.suspend()是过时的方法，使用suspend()导致线程进入停滞状态，该线程会一直持有对象的监视器，suspend()容易引起死锁问题。

        object.wait()使当前线程出于“不可运行”状态，和sleep()不同的是wait是object的方法而不是thread。调用object.wait()时，线程先要获取这个对象的对象锁，当前线程必须在锁对象保持同步，把当前线程添加到等待队列中，随后另一线程可以同步同一个对象锁来调用object.notify()，这样将唤醒原来等待中的线程，然后释放该锁。基本上wait()/notify()与sleep()/interrupt()类似，只是前者需要获取对象锁。




132，什么是线程饿死，什么是活锁？

        当所有线程阻塞，或者由于需要的资源无效而不能处理，不存在非阻塞线程使资源可用。JavaAPI中线程活锁可能发生在以下情形：

        1，当所有线程在程序中执行Object.wait(0)，参数为0的wait方法。程序将发生活锁直到在相应的对象上有线程调用Object.notify()或者Object.notifyAll()。

        2，当所有线程卡在无限循环中。




133，什么是Java Timer类？如何创建一个有特定时间间隔的任务？

        java.util.Timer是一个工具类，可以用于安排一个线程在未来的某个特定时间执行。Timer类可以用安排一次性任务或者周期任务。

        java.util.TimerTask是一个实现了Runnable接口的抽象类，我们需要去继承这个类来创建我们自己的定时任务并使用Timer去安排它的执行。







134，Java中的同步集合与并发集合有什么区别？

        同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。

        在Java1.5之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。

        Java5介绍了并发集合像ConcurrentHashMap，不仅提供线程安全还用锁分离和    内部分区等现代技术提高了可扩展性。




135，同步方法和同步块，哪个是更好的选择？

        同步块是更好的选择，因为它不会锁住整个对象（当然你也可以让它锁住整个对象）。同步方法会锁住整个对象，哪怕这个类中有多个不相关联的同步块，这通常会导致他们停止执行并需要等待获得这个对象上的锁。




136，什么是线程池？ 为什么要使用它？

        创建线程要花费昂贵的资源和时间，如果任务来了才创建线程那么响应时间会变长，而且一个进程能创建的线程数有限。

        为了避免这些问题，在程序启动的时候就创建若干线程来响应处理，它们被称为线程池，里面的线程叫工作线程。

        从JDK1.5开始，Java API提供了Executor框架让你可以创建不同的线程池。比如单线程池，每次处理一个任务；数目固定的线程池或者是缓存线程池（一个适合很多生存期短的任务的程序的可扩展线程池）。





137，Java中invokeAndWait 和 invokeLater有什么区别？

        这两个方法是Swing API 提供给Java开发者用来从当前线程而不是事件派发线程更新GUI组件用的。InvokeAndWait()同步更新GUI组件，比如一个进度条，一旦进度更新了，进度条也要做出相应改变。如果进度被多个线程跟踪，那么就调用invokeAndWait()方法请求事件派发线程对组件进行相应更新。而invokeLater()方法是异步调用更新组件的。





138，多线程中的忙循环是什么?

        忙循环就是程序员用循环让一个线程等待，不像传统方法wait(), sleep() 或 yield() 它们都放弃了CPU控制，而忙循环不会放弃CPU，它就是在运行一个空循环。这么做的目的是为了保留CPU缓存。

        在多核系统中，一个等待线程醒来的时候可能会在另一个内核运行，这样会重建缓存。为了避免重建缓存和减少等待重建的时间就可以使用它了。


赢在面试之Java泛型篇（14）   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/GrzE3jjrI0ecIIzAQV-0dw

139. Java中的泛型是什么 ? 使用泛型的好处是什么?

        泛型是Java SE 1.5的新特性，泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。

好处：

        1、类型安全，提供编译期间的类型检测

       2、前后兼容

        3、泛化代码,代码可以更多的重复利用

        4、性能较高，用GJ(泛型JAVA)编写的代码可以为java编译器和虚拟机带来更多的类型信息，这些信息对java程序做进一步优化提供条件。

 

140，Java的泛型是如何工作的 ? 什么是类型擦除 ?如何工作？

       1、类型检查：在生成字节码之前提供类型检查

        2、类型擦除：所有类型参数都用他们的限定类型替换，包括类、变量和方法（类型擦除）

        3、如果类型擦除和多态性发生了冲突时，则在子类中生成桥方法解决

        4、如果调用泛型方法的返回类型被擦除，则在调用该方法时插入强制类型转换

类型擦除：

        所有类型参数都用他们的限定类型替换：

比如T->Object   ? extends BaseClass->BaseClass


如何工作：


        泛型是通过类型擦除来实现的，编译器在编译时擦除了所有类型相关的信息，所以在运行时不存在任何类型相关的信息。例如 List<String>在运行时仅用一个List来表示。这样做的目的，是确保能和Java 5之前的版本开发二进制类库进行兼容。你无法在运行时访问到类型参数，因为编译器已经把泛型类型转换成了原始类型。根据你对这个泛型问题的回答情况，你会得到一些后续提问，比如为什么泛型是由类型擦除来实现的或者给你展示一些会导致编译器出错的错误泛型代码。

 

141，你可以把List<String>传递给一个接受List<Object>参数的方法吗？

        对任何一个不太熟悉泛型的人来说，这个Java泛型题目看起来令人疑惑，因为乍看起来String是一种Object，所以 List<String>应当可以用在需要List<Object>的地方，但是事实并非如此。真这样做的话会导致编译错误。如果你再深一步考虑，你会发现Java这样做是有意义的，因为List<Object>可以存储任何类型的对象包括String, Integer等等，而List<String>却只能用来存储String s。

List<Object> objectList;

List<String> stringList;

objectList = stringList; //compilation error incompatible types

 

142，如何阻止Java中的类型未检查的警告?

        如果你把泛型和原始类型混合起来使用，例如下列代码，java 5的javac编译器会产生类型未检查的警告，例如

List<String> rawList = newArrayList()

注意: Hello.java使用了未检查或称为不安全的操作;

这种警告可以使用@SuppressWarnings(“unchecked”)注解来屏蔽。

 

143，Java中List<Object>和原始类型List之间的区别?

        原始类型和带参数类型<Object>之间的主要区别是，在编译时编译器不会对原始类型进行类型安全检查，却会对带参数的类型进行检查，通过使用Object作为类型，可以告知编译器该方法可以接受任何类型的对象，比如String或Integer。

        这道题的考察点在于对泛型中原始类型的正确理解。它们之间的第二点区别是，你可以把任何带参数的类型传递给原始类型List，但却不能把List<String>传递给接受 List<Object>的方法，因为会产生编译错误。

 

144，编写一段泛型程序来实现LRU缓存?

        对于喜欢Java编程的人来说这相当于是一次练习。给你个提示，LinkedHashMap可以用来实现固定大小的LRU缓存，当LRU缓存已经满了的时候，它会把最老的键值对移出缓存。

        LinkedHashMap提供了一个称为removeEldestEntry()的方法，该方法会被put() 和putAll()调用来删除最老的键值对。当然，如果你已经编写了一个可运行的JUnit测试，你也可以随意编写你自己的实现代码。

 

145，Array中可以用泛型吗?

        这可能是Java泛型面试题中最简单的一个了，当然前提是你要知道Array事实上并不支持泛型，这也是为什么Joshua Bloch在Effective Java一书中建议使用List来代替Array，因为List可以提供编译期的类型安全保证，而Array却不能。

 

146，如何编写一个泛型方法，让它能接受泛型参数并返回泛型类型?

        编写泛型方法并不困难，你需要用泛型类型来替代原始类型，比如使用T, E or K,V等被广泛认可的类型占位符。最简单的情况下，一个泛型方法可能会像这样：

   public V put(K key, V value) {

   return cahe.put(key,value);

}

 

147，C++模板和java泛型之间有何不同？

        java泛型实现根植于“类型消除”这一概念。当源代码被转换为Java虚拟机字节码时，这种技术会消除参数化类型。有了Java泛型，我们可以做的事情也并没有真正改变多少；他只是让代码变得漂亮些。鉴于此，Java泛型有时也被称为“语法糖”。

        这和 C++模板截然不同。在 C++中，模板本质上就是一套宏指令集，只是换了个名头，编译器会针对每种类型创建一份模板代码的副本。

由于架构设计上的差异，Java泛型和C++模板有很多不同点：

   C++模板可以使用int等基本数据类型。Java则不行，必须转而使用Integer。

    在Java中，可以将模板的参数类型限定为某种特定类型。

    在C++中，类型参数可以实例化，但java不支持。

    在Java中，类型参数不能用于静态方法(?)和变量，因为它们会被不同类型参数指定的实例共享。在C++，这些类时不同的，因此类型参数可以用于静态方法和静态变量。

        在Java中，不管类型参数是什么，所有的实例变量都是同一类型。类型参数会在运行时被抹去。在C++中，类型参数不同，实例变量也不同。


Java并发知识点总结   
 
编辑词条   









   
      
 
转载：https://mp.weixin.qq.com/s/HHW5YwzOmgNJggtBWSn8-g



 前言：Java语言一个重要的特点就是内置了对并发的支持，让Java大受企业和程序员的欢迎。同时，如果想要提升自己的技术，Java并发知识必不可少，这里简单整理了一些相关内容，希望可以起到抛砖引玉的作用。




1，Java内存模型是什么？

        Java内存模型规定和指引Java程序在不同的内存架构、CPU和操作系统间有确定性地行为。它在多线程的情况下尤其重要。Java内存模型对一个线程所做的变动能被其它线程可见提供了保证，它们之间是先行发生关系。这个关系定义了一些规则让程序员在并发编程时思路更清晰。比如，先行发生关系确保了：

        线程内的代码能够按先后顺序执行，这被称为程序次序规则。

        对于同一个锁，一个解锁操作一定要发生在时间上后发生的另一个锁定操作之前，也叫做管程锁定规则。

        前一个对volatile的写操作在后一个volatile的读操作之前，也叫volatile变量规则。

        一个线程内的任何操作必需在这个线程的start()调用之后，也叫作线程启动规则。

        一个线程的所有操作都会在线程终止之前，线程终止规则。

        一个对象的终结操作必需在这个对象构造完成之后，也叫对象终结规则。

可传递性

更多介绍可以移步并发编程网：

（深入理解java内存模型系列文章：http://ifeve.com/java-memory-model-0）




2，Java中interrupted 和isInterruptedd方法的区别？

        interrupted() 和 isInterrupted()的主要区别是前者会将中断状态清除而后者不会。Java多线程的中断机制是用内部标识来实现的，调用Thread.interrupt()来中断一个线程就会设置中断标识为true。当中断线程调用静态方法Thread.interrupted()来检查中断状态时，中断状态会被清零。

        非静态方法isInterrupted()用来查询其它线程的中断状态且不会改变中断状态标识。简单的说就是任何抛出InterruptedException异常的方法都会将中断状态清零。无论如何，一个线程的中断状态都有可能被其它线程调用中断来改变。




3，Java中的同步集合与并发集合有什么区别？

        同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。在Java1.5之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。Java5介绍了并发集合像ConcurrentHashMap，不仅提供线程安全还用锁分离和内部分区等现代技术提高了可扩展性。

        不管是同步集合还是并发集合他们都支持线程安全，他们之间主要的区别体现在性能和可扩展性，还有他们如何实现的线程安全上。

        同步HashMap, Hashtable, HashSet, Vector, ArrayList 相比他们并发的实现（ConcurrentHashMap, CopyOnWriteArrayList, CopyOnWriteHashSet）会慢得多。造成如此慢的主要原因是锁， 同步集合会把整个Map或List锁起来，而并发集合不会。并发集合实现线程安全是通过使用先进的和成熟的技术像锁剥离。

        比如ConcurrentHashMap 会把整个Map 划分成几个片段，只对相关的几个片段上锁，同时允许多线程访问其他未上锁的片段。

        同样的，CopyOnWriteArrayList 允许多个线程以非同步的方式读，当有线程写的时候它会将整个List复制一个副本给它。

        如果在读多写少这种对并发集合有利的条件下使用并发集合，这会比使用同步集合更具有可伸缩性。




4，什么是线程池？ 为什么要使用它？

        创建线程要花费昂贵的资源和时间，如果任务来了才创建线程那么响应时间会变长，而且一个进程能创建的线程数有限。为了避免这些问题，在程序启动的时候就创建若干线程来响应处理，它们被称为线程池，里面的线程叫工作线程。从JDK1.5开始，Java API提供了Executor框架让你可以创建不同的线程池。比如单线程池，每次处理一个任务；数目固定的线程池或者是缓存线程池（一个适合很多生存期短的任务的程序的可扩展线程池）

        线程池的作用，就是在调用线程的时候初始化一定数量的线程，有线程过来的时候，先检测初始化的线程还有空的没有，没有就再看当前运行中的线程数是不是已经达到了最大数，如果没有，就新分配一个线程去处理。

        就像餐馆中吃饭一样，从里面叫一个服务员出来；但如果已经达到了最大数，就相当于服务员已经用尽了，那没得办法，另外的线程就只有等了，直到有新的“服务员”为止。

        线程池的优点就是可以管理线程，有一个高度中枢，这样程序才不会乱，保证系统不会因为大量的并发而因为资源不足挂掉。




5，Java中活锁和死锁有什么区别？

        活锁：一个线程通常会有会响应其他线程的活动。如果其他线程也会响应另一个线程的活动，那么就有可能发生活锁。同死锁一样，发生活锁的线程无法继续执行。然而线程并没有阻塞——他们在忙于响应对方无法恢复工作。这就相当于两个在走廊相遇的人：甲向他自己的左边靠想让乙过去，而乙向他的右边靠想让甲过去。可见他们阻塞了对方。甲向他的右边靠，而乙向他的左边靠，他们还是阻塞了对方。

        死锁：两个或更多线程阻塞着等待其它处于死锁状态的线程所持有的锁。死锁通常发生在多个线程同时但以不同的顺序请求同一组锁的时候，死锁会让你的程序挂起无法完成任务。




6，如何避免死锁？

死锁的发生必须满足以下四个条件：

        互斥条件：一个资源每次只能被一个进程使用。

        请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。

        不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。

        循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。
三种用于避免死锁的技术： 
        加锁顺序（线程按照一定的顺序加锁）

        加锁时限（线程尝试获取锁的时候加上一定的时限，超过时限则放弃对该锁的请求，并释放自己占有的锁）

        死锁检测

（死锁原因及如何避免更深理解移步：http://blog.csdn.net/ls5718/article/details/51896159）




7，notify()和notifyAll()有什么区别？
        1，notify()和notifyAll()都是Object对象用于通知处在等待该对象的线程的方法。
        2，void notify(): 唤醒一个正在等待该对象的线程。
        3，void notifyAll(): 唤醒所有正在等待该对象的线程。
 两者的最大区别在于：
         notifyAll使所有原来在该对象上等待被notify的线程统统退出wait的状态，变成等待该对象上的锁，一旦该对象被解锁，他们就会去竞争。
 
         notify他只是选择一个wait状态线程进行通知，并使它获得该对象上的锁，但不惊动其他同样在等待被该对象notify的线程们，当第一个线程运行完毕以后释放对象上的锁，此时如果该对象没有再次使用notify语句，即便该对象已经空闲，其他wait状态等待的线程由于没有得到该对象的通知，继续处在wait状态，直到这个对象发出一个notify或notifyAll，它们等待的是被notify或notifyAll，而不是锁。




8，什么是可重入锁（ReentrantLock）？ 

        Java.util.concurrent.lock 中的 Lock 框架是锁定的一个抽象，它允许把锁定的实现作为Java 类，而不是作为语言的特性来实现。这就为Lock 的多种实现留下了空间，各种实现可能有不同的调度算法、性能特性或者锁定语义。            ReentrantLock 类实现了Lock ，它拥有与synchronized 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性。此外，它还提供了在激烈争用情况下更佳的性能。（换句话说，当许多线程都想访问共享资源时，JVM可以花更少的时候来调度线程，把更多时间用在执行线程上。）
          Reentrant 锁意味着什么呢？简单来说，它有一个与锁相关的获取计数器，如果拥有锁的某个线程再次得到锁，那么获取计数器就加1，然后锁需要被释放两次才能获得真正释放。这模仿了synchronized 的语义；如果线程进入由线程已经拥有的监控器保护的synchronized 块，就允许线程继续进行，当线程退出第二个（或者后续）synchronized块的时候，不释放锁，只有线程退出它进入的监控器保护的第一个synchronized 块时，才释放锁。




9，读写锁可以用于什么应用场景？
        读写锁可以用于 “多读少写” 的场景，读写锁支持多个读操作并发执行，写操作只能由一个线程来操作
        ReadWriteLock对向数据结构相对不频繁地写入，但是有多个任务要经常读取这个数据结构的这类情况进行了优化。ReadWriteLock使得你可以同时有多个读取者，只要它们都不试图写入即可。如果写锁已经被其他任务持有，那么任何读取者都不能访问，直至这个写锁被释放为止。
ReadWriteLock 对程序性能的提高主要受制于如下几个因素：
1，数据被读取的频率与被修改的频率相比较的结果。
2，读取和写入的时间
3，有多少线程竞争
4，是否在多处理机器上运行
        对Java线程，并发方面的知识，这里发现了一个很不错的网站（并发编程网），这个网站对这块知识罗列有条理又很系统，有这方面需求想要深入学习的小伙伴可以看看：http://ifeve.com


     

    	          	           	           	          	           	       
