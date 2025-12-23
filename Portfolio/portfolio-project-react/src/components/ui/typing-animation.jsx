import { useEffect, useMemo, useRef, useState } from "react";
import { cn } from "@/lib/utils";

/**
 * TypingAnimation
 * Usage:
 *  <TypingAnimation>My text...</TypingAnimation>
 *  or
 *  <TypingAnimation text="My text..." />
 *
 * Props:
 * - text?: string
 * - children?: string
 * - speed?: number (ms per char, default 18)
 * - startDelay?: number (ms, default 0)
 * - showCursor?: boolean (default true)
 * - cursorChar?: string (default "▍")
 */
export function TypingAnimation({
  text,
  children,
  className,
  speed = 50,
  startDelay = 0,
  showCursor = true,
  cursorChar = "▍",
}) {
  const fullText = useMemo(() => {

    if (typeof text === "string") return text;
    if (typeof children === "string") return children;

    return "";
  }, [text, children]);

  const [displayed, setDisplayed] = useState("");
  const [done, setDone] = useState(false);

  const idxRef = useRef(0);
  const timerRef = useRef(null);

  useEffect(() => {


    setDisplayed("");
    setDone(false);
    idxRef.current = 0;

    if (!fullText) return;

    const start = () => {
      timerRef.current = window.setInterval(() => {
        idxRef.current += 1;
        setDisplayed(fullText.slice(0, idxRef.current));
        if (idxRef.current >= fullText.length) {
          window.clearInterval(timerRef.current);
          timerRef.current = null;
          setDone(true);
        }
      }, Math.max(8, speed));
    };

    const delayId = window.setTimeout(start, Math.max(0, startDelay));

    return () => {
      window.clearTimeout(delayId);
      if (timerRef.current) window.clearInterval(timerRef.current);
      timerRef.current = null;
    };
  }, [fullText, speed, startDelay]);

  return (
    <p className={cn("whitespace-pre-line", className)}>
      {displayed}
      {showCursor && !done ? (
        <span className="inline-block align-baseline opacity-80 animate-pulse">
          {cursorChar}
        </span>
      ) : null}
    </p>
  );
}