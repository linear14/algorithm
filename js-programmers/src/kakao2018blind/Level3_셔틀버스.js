// 자리가 남아있다면 버스 도착 시간
// 자리가 없다면 마지막 사람 시간 - 1
// 대신 버스 시간 안에는 타야됨
const solution = (n, t, m, timetable) => {
  const remainCrew = timetable.map(item => {
    const [hour, min] = item.split(':').map(str => +str);
    return 60 * hour + min;
  })
  remainCrew.sort((a, b) => b - a);
  
  for(let i = 1; i <= n; i++) {
    const busTime = 540 + t * (i - 1);
    
    if(i === n) {
      if(remainCrew.length < m) {
        return minToTimeString(busTime);
      }
      const lastCrewIdx = remainCrew.length - m > 0 ? remainCrew.length - m : 0;
      const lastCrew = remainCrew[lastCrewIdx];
      return minToTimeString(lastCrew > busTime ? busTime : lastCrew - 1);
    }
    else {
      let mCnt = 0;
      while(mCnt++ < m) {
        if(remainCrew.length > 0 && remainCrew[remainCrew.length - 1] <= busTime) {
          remainCrew.pop();
        }
      }
    }
  }
}

const minToTimeString = (oldMin) => {
  const hour = (Math.floor(oldMin / 60)).toString().padStart(2, '0');
  const min = (oldMin % 60).toString().padStart(2, '0');
  return `${hour}:${min}`
}

const testData = [
  { n	: 1, t: 1, m: 5, timetable: ["08:00", "08:01", "08:02", "08:03"] },
  { n	: 2, t: 10, m: 2, timetable: ["09:10", "09:09", "08:00"] },
  { n	: 2, t: 1, m: 2, timetable: ["09:00", "09:00", "09:00", "09:00"] },
  { n	: 1, t: 1, m: 5, timetable: ["00:01", "00:01", "00:01", "00:01", "00:01"] },
  { n	: 1, t: 1, m: 1, timetable: ["23:59"] },
  { n	: 1, t: 1, m: 3, timetable: ["08:00", "08:01", "08:02", "08:03"] },
  { n	: 10, t: 60, m: 45, timetable: ["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"] },
];

testData.forEach(({ n, t, m, timetable }) => {
  console.log(solution(n, t, m, timetable));
});
