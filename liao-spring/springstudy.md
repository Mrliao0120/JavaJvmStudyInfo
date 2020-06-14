Bean：
BeanDefinition：bean基本信息  单例 多例

FactoryBean:
    像容器注册组件 
        
        public interface FactoryBean<T> {
         
         @Nullable
         T getObject() throws Exception;
    
         @Nullable
         Class<?> getObjectType();
    
         default boolean isSingleton() {
             return true;
         }
     }
BeanFactory:
    容器本身


BeanPostProcessor


注入模型:AutowireCapableBeanFactory
* AUTOWIRE_NO=0/**根据包扫描定义注入  ComponentScan扫描**/

* AUTOWIRE_BY_NAME=1/**根据名称注入**/

* AUTOWIRE_BY_TYPE=2/**根据构造器注入**/

* AUTOWIRE_CONSTRUCTOR=3/**根据构造器注入**/



org.springframework.beans.factory.config.ConstructorArgumentValues:
spring默认是加载无参构造函数的变量   ConstructorArgumentValues可以指定加载变量







SpringBoot自动装配：
@EnableAutoConfiguration 开启装配
@Import(AutoConfigurationImportSelector.class)
导入AutoConfigurationImportSelector类
   * List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);获取候选配置
       * SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
      				getBeanClassLoader());
      	    * Enumeration<URL> urls = (classLoader != null ?
              					classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
              					ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
              					//FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories" 得到资源
   再将获取到的值全部返回  将META-INF类目录的值全部加入.
   
Spring事务:








BeanUtils:

//获取属性
PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);

