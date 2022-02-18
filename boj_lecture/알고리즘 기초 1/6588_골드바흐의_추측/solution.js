const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const arr = [];
const ans = [];
rl.on('line', (input) => {
  if(+input) arr.push(+input);
  else rl.close();
}).on('close', () => {
  const isPrime = getPrimeChecker();
  const primeList = isPrime.reduce((pre, cur, idx) => { 
    if(cur) pre.push(idx);
    return pre;
  }, [])

  for(let i = 0; i < arr.length; i++) {
    const target = arr[i];
    
    let solved = false;
    for(let j = 0; j < primeList.length; j++) {
      if(isPrime[target - primeList[j]]) {
        ans.push(`${target} = ${primeList[j]} + ${target - primeList[j]}`);
        solved = true;
        break;
      }
    }
    if(!solved) {
      ans.push(`Goldbach's conjecture is wrong.`);
    }
  }
  console.log(ans.join('\n'));
});

const getPrimeChecker = () => {
  const length = 1000001;
  const isPrime = Array.from({ length }, () => true);
  isPrime[0] = false;
  isPrime[1] = false;

  for(let i = 2; i < length; i++) {
    let now = i + i;
    while(now < length) {
      isPrime[now] = false;
      now += i;
    }
  }

  return isPrime;
}