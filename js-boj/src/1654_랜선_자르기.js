const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

rl.on('line', (input) => {
  if(!n) [n, k] = input.split(' ').map(i => +i);
  else {
    arr.push(+input);
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  console.log(sol());
})

let n, k;
const arr = [];

const sol = () => {
  let start = 1;
  let end = Math.max(...arr);
  let ans = 0;

  while(start <= end) {
    let cnt = 0;
    const mid = Math.floor((start + end) / 2);
    arr.forEach(item => cnt += Math.floor(item / mid));
    
    if(cnt >= k) {
      ans = Math.max(ans, mid);
      start = mid + 1;
    }
    else {
      end = mid - 1;
    }
  }
  return ans;
}