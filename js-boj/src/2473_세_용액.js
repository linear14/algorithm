const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  console.log(sol().join(' '));
})

let n;
let arr;

const sol = () => {
  arr.sort((a, b) => a - b);
  let minValue = 3000000001;
  let ans;

  for(let i = 0; i < n; i++) {
    let [s, e] = [i + 1, n - 1];
    while(s < e) {
      const sum = arr[i] + arr[s] + arr[e];
      if(Math.abs(sum) < minValue) {
        minValue = Math.abs(sum);
        ans = [arr[i], arr[s], arr[e]];
      }

      if(sum === 0) {
        return ans;
      }
      else if(sum > 0) {
        e--;
      }
      else {
        s++;
      }
    }
  }
  return ans;
}