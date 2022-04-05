const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n, m;
let arr;

rl.on('line', (input) => {
  if(isNaN(n)) n = +input;
  else if(isNaN(m)) {
    m = +input;
    if(m === 0) {
      arr = [];
      rl.close();
    }
  }
  else {
    arr = input.split(' ');
    rl.close();
  }  
}).on('close', () => {
  let up = n;
  let down = n;

  while(up < 1000000) {
    const upString = up.toString();

    let wrongIdx = -1;
    for(let i = 0; i < upString.length; i++) {
      if(arr.includes(upString[i])) {
        wrongIdx = i; 
        break;
      }
    }

    if(wrongIdx < 0) break;

    const postfix = '9'.repeat(upString.length - (wrongIdx + 1));
    const newNumber = Number(upString.slice(0, wrongIdx + 1) + postfix);
    up = newNumber + 1;
  }

  while(down > -1) {
    const downString = down.toString();

    let wrongIdx = -1;
    for(let i = 0; i < downString.length; i++) {
      if(arr.includes(downString[i])) {
        wrongIdx = i;
        break;
      }
    }

    if(wrongIdx < 0) break;

    if(down === 0) {
      down--;
    }
    else {
      const postfix = '0'.repeat(downString.length - (wrongIdx + 1));
      const newNumber = Number(downString.slice(0, wrongIdx + 1) + postfix);
      down = newNumber - 1;
    }
  }

  console.log(Math.min(
    up.toString().length + up - n,
    down !== -1 ? down.toString().length + n - down : 1000000,
    n >= 100 ? n - 100 : 100 - n
  ));
});