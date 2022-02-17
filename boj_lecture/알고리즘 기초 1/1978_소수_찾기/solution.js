const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let nums;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    nums = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  console.log(nums.reduce((pre, cur) => pre + isPrime[cur], 0))
})

const isPrime = Array.from({ length: 1001 }, () => true);
isPrime[1] = false;

for(let i = 2; i <= 500; i++) {
  let now = i + i;
  while(now <= 1000) {
    isPrime[now] = false;
    now += i;
  }
}