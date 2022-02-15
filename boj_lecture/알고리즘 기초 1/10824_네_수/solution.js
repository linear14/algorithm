const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let arr;
rl.on('line', (input) => {
  arr = input.split(' ');
  rl.close();
}).on('close', () => {
  console.log(Number(arr[0] + arr[1]) + Number(arr[2] + arr[3]));
})