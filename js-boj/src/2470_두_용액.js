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
  let [start, end] = [0, n - 1];
  let near = 2000000001;
  let ans = [];

  while(start !== end) {
    const sum = arr[start] + arr[end];
    if(Math.abs(sum) < near) {
      near = Math.abs(sum);
      ans = [arr[start], arr[end]];
    }

    if(sum === 0) {
      return [arr[start], arr[end]];
    }
    else if(sum > 0) {
      end--;
    }
    else {
      start++;
    }
  }

  return ans;
}