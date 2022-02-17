const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(input.split(' ').map(i => +i));
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  const ans = [];
  arr.forEach(([a, b]) => ans.push((a * b) / getGCD(a, b)));
  console.log(ans.join('\n'));
})

const getGCD = (a, b) => {
  while(b !== 0) {
    const temp = a;
    a = b;
    b = temp % b;
  }
  return a;
} 