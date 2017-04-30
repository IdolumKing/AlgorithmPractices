# Count Primes

这题很有意思，虽然是个简单题，LeetCode却给了很多条提示，一条接一条的。  
很多算法中都出现了找质数，平常判断一个数是不是质数，都遍历n能否被1到Sqrt(n)的数整除。  
这里用的是 [埃拉托斯特尼筛法](https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95)([Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes))

![sss](http://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif?_=4462810)

2是质数，把2的倍数都划掉，接下来找没有被划掉的数字3，把3的倍数划掉，以此类推。

``` Java
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        //一开始设置都为质数，即notPrime数组的值都是false
        //LeetCode上是prime数组，还需要遍历一次赋值为true
        int result = 0;
        for (int i = 2; i < n; i++){
            if (!notPrime[i]){
                result++;
                for (int j = 2; i * j < n; j ++){
                    notPrime[i * j] = true;
                }
            }
        }
        return result;
    }
}
```