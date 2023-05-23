package os.process;

import java.util.concurrent.Semaphore;

/**
 * 병행 프로세스에서 발생할 수 있는 문제점을 정의
 * 1.
 * 2. 생산자-소비자 문제
 * 3. 판독기-기록기 문제
 */
public class Concurrency {
/*

    public static int mutex = 1;

    public static void main(String[] args) {

        tmp();
        case2();
        case3();

    }

    */
/**
     * 세마포어를 활용한 상호배제
     * *//*

    private static void tmp() {
        public static int mutex = 1;
        P(mutex);
        임계영역();
        v(mutex);
    }

    */
/**
     * 3. 판독기-기록기 문제
     *//*


    private static void case3() {

        public static int wrt = 1;
        public static int mutex = 1;
        public static int rcount = 1;


        // 기록기
        p(writ);
        // 임계영역 진행 - 데이터 기록
        ...
        v(writ);

        // 판독기
        p(mutex);
        rcount++;
        if (rcount == 1) {
            p(wrt);
        }
        v(mutex);
        // 임계영역 진행 - 데이터 판독
        ...
        p(mutex);
        rcount--;
        if (rcount == 0) {
            v(wrt);
        }
        v(mutex);
        

    }


    private static void case4(){
        public static int rd = 1;
        public static int wrt = 1;
        public static int mutex1 = 1;
        public static int mutex2 = 1;
        public static int mutex3 = 1;
        public static int rcount = 1;
        public static int wcount = 1;


        // 기록기
        p(mutex2);
        wcount++;
        if (wcount == 1) {
            p(rd);
        }
        v(mutex2);
        p(wrt);
        // 임계영역 진행 - 데이터 기록
        v(wrt);
        p(mutex2);
        wcount--;
        if (wcount == 0) {
            v(rd);
        }
        v(mutex2);

        // 판독기
        p(mutex3);
        p(rd);
        p(mutex1);
        rcount++;
        if (rcount == 1) {
            p(wrt);
        }
        v(mutex1);
        v(rd);
        v(mutex3);
        // 임계영역 진행 - 데이터 판독
        ...
        p(mutex1);
        rcount--;
        if (rcount == 0) {
            v(wrt);
        }
        v(mutex1);


    }


        */
/**
     * 2. 생산자-소비자 문제
     *//*

    private static void case2() {


        public static int mutex = 1;
        public static int empty = n; // 현재 사용가능한 버퍼 개수
        public static int full = 0; // 사용 중인 버퍼 개수


        // 생산자
        while (true) {
            p(empty); // 버퍼 사용 가능여부 확인
            p(mutex)
            // 임계영역 진행 - 데이터 생산
            ...
            v(mutex);
            v(full);
        }
    
        //소비자
        while (true) {
            p(full); // 버퍼 사용 가능여부 확인
            p(mutex)
            // 임계영역 진행 - 데이터 소비
            ...
            v(mutex);
            v(empty);
        }

    }

    public static class Semaphore {

        private static int mutex  = 1;
        private static int empty = 10; // 현재 사용가능한 버퍼 사이즈

        private static int full = 0; // 현재 사용중인 버퍼 사이즈


        public synchronized void p(Semaphore s) {
            if (s > 0) {
                s--;
                // 프로세스 진행
            } else {
                // 현재 프로세스 대기
            }
        }

        public synchronized void v(Semaphore s) {
            if (existWaitingProcess()) {
                s++;
            } else {
                // 대기 프로세스 1개 진행
            }
        }

        public synchronized void pEmpty() {
            if (this.empty > 0) {
                this.empty--;
                // 프로세스 진행
            } else {
                // wait
            }
        }

        public synchronized void vEmpty() {
            if (existWaitingProcess()) {
                // 해당 프로세스 진행
            } else {
                this.empty++;
            }
        }

        public synchronized void pFull() {
            if (this.full > 0) {
                this.full--;
                // 프로세스 진행
            } else {
                // wait
            }
        }

        public synchronized void vFull() {
            if (existWaitingProcess()) {
                // 해당 프로세스 진행
            } else {
                this.full++;
            }
        }

        */
/**
         * 대기 중인 프로세스가 있는가
         *//*

        private static boolean existWaitingProcess() {
            return true;
        }

    }

    public static void publish() {
        while (true) {
            // .. 데이터 생산
        }
    }

    public static void subscribe() {
        while (true) {
            // .. 데이터 소비
        }
    }
*/

}
