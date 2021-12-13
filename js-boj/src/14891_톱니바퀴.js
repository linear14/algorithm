const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

const arr = [];
let k;
let cmds = [];
rl.on('line', (input) => {
  if(arr.length < 4) {
    arr.push(input.split('').map(i => Number(i)));
  }
  else {
    if(!k) k = Number(input);
    else {
      cmds.push(input.split(' ').map(i => Number(i)));
      if(cmds.length === k) {
        rl.close();
      }
    }
  }
}).on('close', () => {
  console.log(sol());
})

let rotationInfo = [];
const sol = () => {
  cmds.forEach(cmd => {
    rotationInfo = [[cmd[0], cmd[1] + 1]]; 
    compare(cmd[0], cmd[1] + 1, true);
    compare(cmd[0], cmd[1] + 1, false);
    rotationInfo.forEach((item) => rotate(item[0], item[1]));
  });
  return getScore();
}

const compare = (target, isClockWise, isLeft) => {
  const [tl, tr] = [arr[target - 1][6], arr[target -1][2]];

  // 왼쪽이랑 비교 가능
  if(isLeft && target !== 1 && tl !== arr[target - 2][2]) {
    compare(target - 1, !isClockWise, true);
    rotationInfo.push([target - 1, !isClockWise])
  }
  // 오른쪽이랑 비교 가능
  if(!isLeft && target !== 4 && tr !== arr[target][6]) {
    compare(target + 1, !isClockWise, false);
    rotationInfo.push([target + 1, !isClockWise])
  }
}

const rotate = (target, isClockWise) => {
  const temp = arr[target - 1];
  if(isClockWise) {
    const last = temp.pop();
    temp.unshift(last);
  }
  else {
    const first = temp.shift();
    temp.push(first);
  }
}

const getScore = () => {
  return arr[0][0] + arr[1][0] * 2 + arr[2][0] * 4 + arr[3][0] * 8;
}