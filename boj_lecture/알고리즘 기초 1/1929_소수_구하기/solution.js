const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let arr;
rl.on('line', (input) => {
  arr = input.split(' ').map(i => +i);
  rl.close();
}).on('close', () => {
  const [a, b] = arr;
  const isPrime = Array.from({ length: b + 1 }, () => true);
  isPrime[1] = false;

  for(let i = 2; i < Math.floor(b); i++) {
    let now = i + i;
    while(now <= b) {
      isPrime[now] = false;
      now += i;
    }
  }

  const ans = [];
  for(let i = a; i <= b; i++) {
    if(isPrime[i]) ans.push(i); 
  }
  console.log(ans.join('\n'));
})