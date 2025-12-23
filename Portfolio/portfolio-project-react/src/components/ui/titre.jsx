import React, { memo } from "react";

/**
 * @typedef {Object} AuroraTextProps
 * @property {React.ReactNode} children
 * @property {string=} className
 * @property {string[]=} colors
 * @property {number=} speed
 */

/**
 * @type {React.MemoExoticComponent<(props: AuroraTextProps) => JSX.Element>}
 */
export const AuroraText = memo(function AuroraText({
  children,
  className = "",
  colors = ["#FF0080", "#7928CA", "#0070F3", "#38bdf8"],
  speed = 1,
}) {
  const gradientStyle = {
    backgroundImage: `linear-gradient(135deg, ${colors.join(", ")}, ${colors[0]})`,
    WebkitBackgroundClip: "text",
    WebkitTextFillColor: "transparent",
    animationDuration: `${10 / speed}s`,
  };

  return (
    <span className={`relative inline-block ${className}`}>
      <span className="sr-only">{children}</span>
        <h2 className="text-4xl md:text-5xl lg:text-8xl font-bold tracking-tight">
      <span
        className="animate-aurora relative bg-size-[200%_auto] bg-clip-text text-transparent"
        style={gradientStyle}
        aria-hidden="true"
      >
        {children}
      </span>
        </h2>
    </span>
  );
});

AuroraText.displayName = "AuroraText";
