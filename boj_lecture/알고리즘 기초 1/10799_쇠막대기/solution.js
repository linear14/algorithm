const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let arr;
rl.on('line', (input) => {
  arr = input.split('');
  rl.close();
}).on('close', () => {
  console.log(solution());
})

const solution = () => {
  let ans = 0;
  let isLaser = false;
  const s = [];

  for(let i = 0; i < arr.length; i++) {
    const next = arr[i];
    
    if(next === '(') {
      s.push('(');
      isLaser = true;
    }
    else {
      if(isLaser) {
        s.pop();
        ans += s.length;
        isLaser = false;
      }
      else {
        s.pop();
        ans += 1;
      }
    }
  }
  return ans;
}