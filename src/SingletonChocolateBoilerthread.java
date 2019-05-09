public class SingletonChocolateBoilerthread {
    private class SigletonChocolateBoilerthread {
        private boolean empty;
        private boolean boiled;
        private static  SigletonChocolateBoilerthread instance;
        private static Object mutex = new Object();

        private SigletonChocolateBoiler() {
            empty = true;
            boiled = false;
        }

        public static SigletonChocolateBoilerthread getInstance()
        {
            SingletonChocolateBoiler result = instance;
            if(result == null)
            {
                synchronized (mutex) {
                    result = instance;
                    if (result==null)
                    {
                        instance = result=new SigletonChocolateBoilerthread();
                    }

                }
            }
            return result;
        }

        public void fill(){
            if(isEmpty()){
                empty = false;
                boiled = false;
            }
        }

        public void drain(){
            if(isEmpty() && isBoiled()){
                //drain the boiled milk and chocolate
                empty = true;
            }
        }

        public void boil(){
            if(!isEmpty() && isBoiled()){
                //bring the contents to a boil
                boiled = true;
            }
        }

        public boolean isEmpty(){
            return empty;
        }

        public boolean isBoiled(){
            return boiled;
        }
    }
}
