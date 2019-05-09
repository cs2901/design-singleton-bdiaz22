public class Multithreading {
    private static Object mutex = new Object();
    public static SigletonChocolateBoiler getInstance()
    {
        SingletonChocolateBoiler result = instance;
        if(result == null)
        {
            synchronized (mutex) {
                result = instance;
                if (result==null)
                {
                    instance = result=new SigletonChocolateBoiler();
                }

            }
        }
        return result;
    }
}
