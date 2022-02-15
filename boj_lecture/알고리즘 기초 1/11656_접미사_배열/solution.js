const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let str;
rl.on('line', (input) => {
  str = input;
  rl.close();
}).on('close', () => {
  const arr = Array.from({ length: str.length }, (_, idx) => str.substring(idx));
  console.log(arr.sort().join('\n'));
})